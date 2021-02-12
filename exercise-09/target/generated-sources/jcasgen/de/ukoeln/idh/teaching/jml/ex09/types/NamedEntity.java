

   
/* Apache UIMA v3 - First created by JCasGen Fri Jan 29 14:24:24 CET 2021 */

package de.ukoeln.idh.teaching.jml.ex09.types;
 

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;

import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.impl.TypeSystemImpl;
import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;


import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Jan 29 14:24:24 CET 2021
 * XML source: C:/Users/thoma/Documents/Studenten/MASTER/03 Java ML UIMA/exercises/exercise-09/target/jcasgen/typesystem.xml
 * @generated */
public class NamedEntity extends Annotation {
 
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static String _TypeName = "de.ukoeln.idh.teaching.jml.ex09.types.NamedEntity";
  
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NamedEntity.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
 
  /* *******************
   *   Feature Offsets *
   * *******************/ 
   
  public final static String _FeatName_NEClass = "NEClass";
  public final static String _FeatName_confidence = "confidence";
  public final static String _FeatName_source = "source";


  /* Feature Adjusted Offsets */
  private final static CallSite _FC_NEClass = TypeSystemImpl.createCallSite(NamedEntity.class, "NEClass");
  private final static MethodHandle _FH_NEClass = _FC_NEClass.dynamicInvoker();
  private final static CallSite _FC_confidence = TypeSystemImpl.createCallSite(NamedEntity.class, "confidence");
  private final static MethodHandle _FH_confidence = _FC_confidence.dynamicInvoker();
  private final static CallSite _FC_source = TypeSystemImpl.createCallSite(NamedEntity.class, "source");
  private final static MethodHandle _FH_source = _FC_source.dynamicInvoker();

   
  /** Never called.  Disable default constructor
   * @generated */
  @Deprecated
  @SuppressWarnings ("deprecation")
  protected NamedEntity() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param casImpl the CAS this Feature Structure belongs to
   * @param type the type of this Feature Structure 
   */
  public NamedEntity(TypeImpl type, CASImpl casImpl) {
    super(type, casImpl);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NamedEntity(JCas jcas) {
    super(jcas);
    readObject();   
  } 


  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NamedEntity(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: NEClass

  /** getter for NEClass - gets to distinguish between person, organization etc.
   * @generated
   * @return value of the feature 
   */
  public String getNEClass() { 
    return _getStringValueNc(wrapGetIntCatchException(_FH_NEClass));
  }
    
  /** setter for NEClass - sets to distinguish between person, organization etc. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setNEClass(String v) {
    _setStringValueNfc(wrapGetIntCatchException(_FH_NEClass), v);
  }    
    
   
    
  //*--------------*
  //* Feature: confidence

  /** getter for confidence - gets 
   * @generated
   * @return value of the feature 
   */
  public long getConfidence() { 
    return _getLongValueNc(wrapGetIntCatchException(_FH_confidence));
  }
    
  /** setter for confidence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setConfidence(long v) {
    _setLongValueNfc(wrapGetIntCatchException(_FH_confidence), v);
  }    
    
   
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSource() { 
    return _getStringValueNc(wrapGetIntCatchException(_FH_source));
  }
    
  /** setter for source - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSource(String v) {
    _setStringValueNfc(wrapGetIntCatchException(_FH_source), v);
  }    
    
  }

    