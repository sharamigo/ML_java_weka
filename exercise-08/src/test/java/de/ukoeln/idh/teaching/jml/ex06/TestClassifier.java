package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

public class TestClassifier {

	Random random = new Random();
	Classifier classifier = new Classifier();

	@BeforeEach
	public void setup() throws FileNotFoundException, IOException {
	}

	/**
	 * This method is used to generate a data set with a specific distribution. For
	 * calculating entropy, the number of classes and their distribution is the
	 * deciding factor. The returned data set contains 100 instances.
	 * 
	 * @param numberOfClasses The number of classes
	 * @param portions        An array giving the absolute number of each of the
	 *                        different classes. The values in the array should add
	 *                        up to 100.
	 * @return A data set containing 100 instances.
	 * @throws IOException If the base arff file can't be loaded
	 */
	public Instances generateDataset(int numberOfClasses, int[] portions) throws IOException {

		// We first generate possible class values
		List<String> attributeValues = new ArrayList<String>();
		for (int i = 0; i < numberOfClasses; i++) {
			attributeValues.add("Class " + i);
		}

		// and assign the created class values to a new attribute called class
		Attribute classAttribute = new Attribute("class", attributeValues);

		// Load the base data set, and add the new attribute, set it as class attribute
		// Adding a new attribute sets all values to "unknown", we have to fix that
		// later
		Instances instances = new Instances(new FileReader("src/test/resources/base.arff"));
		instances.insertAttributeAt(classAttribute, instances.numAttributes());
		instances.setClassIndex(instances.numAttributes() - 1);
		// Set the actual class values by "consuming" the given numbers in the portions
		// array.
		int currentClass = 0;
		// iterate over all instances
		for (Instance instance : instances) {
			// if there are no instances of the current class to produce anymore, we move on
			// to the next
			if (portions[currentClass] == 0) {
				currentClass++;
			}

			// set instance value
			instance.setValue(instances.numAttributes() - 1, currentClass);

			// consume the instance
			portions[currentClass]--;
		}

		// shuffle before returning
		instances.randomize(random);

		return instances;
	}

	@Test
	public void testEntropy() throws IOException {
		// values taken from slides
		assertEquals(0.0, classifier.entropy(generateDataset(1, new int[] { 100 })), 1e-03);
		assertEquals(0.693, classifier.entropy(generateDataset(2, new int[] { 50, 50 })), 1e-03);
		assertEquals(0.562, classifier.entropy(generateDataset(2, new int[] { 75, 25 })), 1e-03);
		assertEquals(1.386294, classifier.entropy(generateDataset(4, new int[] { 25, 25, 25, 25 })), 1e-03);

		// values calculated with R:
		// library(entropy)
		// entropy(c(75,25))
		// entropy(c(5, 25, 10, 5, 5, 10, 10, 10, 10, 10))
		assertEquals(0.5623351, classifier.entropy(generateDataset(2, new int[] { 75, 25 })), 1e-03);
		assertEquals(2.177484,
				classifier.entropy(generateDataset(10, new int[] { 5, 25, 10, 5, 5, 10, 10, 10, 10, 10 })), 1e-03);

		Instances instances = new Instances(new FileReader("src/test/resources/ig.arff"));
		instances.setClassIndex(instances.numAttributes() - 1);
		assertEquals(0.693, classifier.entropy(instances), 1e-03);
	}

	@Test
	public void testInformationGain() throws IOException {
		Instances instances = new Instances(new FileReader("src/test/resources/ig.arff"));
		instances.setClassIndex(instances.numAttributes() - 1);

		assertEquals(0.693, classifier.informationGain(instances, 0), 1e-03);
		assertEquals(0.693 - 2 * 0.5 * 0.693, classifier.informationGain(instances, 1), 1e-03);
		assertEquals(0.693 - (0.8 * 0.6615632 + 0.2 * 0), classifier.informationGain(instances, 2), 1e-03);
	}

	@Test
	public void testTrain() throws FileNotFoundException, IOException {
		Instances instances = new Instances(new FileReader("src/test/resources/treetest.arff"));
		instances.setClassIndex(instances.numAttributes() - 1);
		Classifier cls = new Classifier();
		Tree tree = cls.train(instances);
		System.out.println(tree);
		for (int i = 0; i < instances.numInstances(); i++) {
			Instance instance = instances.get(i);
			assertEquals(instance.classValue(), tree.predict(instance), "Instance " + i);
		}

	}
	
	
	@Test
	public void testSubsets() throws FileNotFoundException, IOException {
		
		Instances instances = new Instances(new FileReader("src/test/resources/treetest.arff"));
		
		
		Instances[] subsets = classifier.subsets(instances, 1);
		assertEquals(subsets.length, instances.attribute(1).numValues());
		
		for (Instances i: subsets) {
			assertEquals(i.numDistinctValues(1), 1); 
		}
		
		ArrayList<Attribute> att = new ArrayList<Attribute>();
		att.add(new Attribute("Testattribute_01"));
		Instances ins = new Instances("0", att, 1);
		assertEquals(classifier.subsets(ins, 0).length, 0);
		
		
	}
	
	@Test
	public void testGetMajority() {		
		
		assertEquals(0, Classifier.getMajority(new int[] { 4, 1 }));
		assertEquals(1, Classifier.getMajority(new int[] { 1, 4 }));
		assertEquals(1, Classifier.getMajority(new int[] { 1, 2 }));
		assertEquals(0, Classifier.getMajority(new int[] { 2, 1 }));
		assertEquals(0, Classifier.getMajority(new int[] { 0, 0 }));
		
	}
	
	@Test
	public void testCountClasses() throws FileNotFoundException, IOException {	
		
		
		Instances instances = new Instances(new FileReader("src/test/resources/treetest.arff"));
		instances.setClassIndex(instances.numAttributes() - 1);
		
		assertArrayEquals(new int[] {5, 5}, Classifier.countClasses(instances)); 
	}

}
