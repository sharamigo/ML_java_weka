package de.ukoeln.idh.teaching.jml.ex09;

import org.apache.uima.cas.CASException;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.ukoeln.idh.teaching.jml.ex09.types.Sentence;
import de.ukoeln.idh.teaching.jml.ex09.types.Token;

public class Main {

	static JCas jcas;

	public static void main(String[] args) throws ResourceInitializationException, CASException {
		jcas = JCasFactory.createText("The dog barks.");
		
		//init sentence-object and set begin and end
		Sentence sentc = new Sentence(jcas);
		sentc.setBegin(0);
		sentc.setEnd(jcas.getDocumentText().length() - 1);
		
		//the
		Token tok1 = new Token(jcas);
		tok1.setBegin(sentc.getBegin());
		tok1.setEnd(2);
		
		//dog
		Token tok2 = new Token(jcas);
		tok2.setBegin(tok1.getEnd()+1);
		tok2.setEnd(6);
    
		//barks
		Token tok3 = new Token(jcas);
		tok3.setBegin(tok2.getEnd()+1);
		tok3.setEnd(13);

	}

}
