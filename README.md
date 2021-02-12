# ML_java_weka

Machine Learning with Java, UIMA and Weka.
UIMA and Weka are Java-frameworks which are developed in order to do machine learning and investigation of large text-files.

### What is UIMA?
Unstructured Information Management applications are software systems that analyze large volumes of unstructured information in order to discover knowledge that is relevant to an end user. An example UIM application might ingest plain text and identify entities, such as persons, places, organizations; or relations, such as works-for or located-at.

UIMA enables applications to be decomposed into components, for example "language identification" => "language specific segmentation" => "sentence boundary detection" => "entity detection (person/place names etc.)". Each component implements interfaces defined by the framework and provides self-describing metadata via XML descriptor files. The framework manages these components and the data flow between them. Components are written in Java or C++; the data that flows between components is designed for efficient mapping between these languages.

![Alt-Text](https://uima.apache.org/images/UimaIs.png "UIMA Framework")
