
/**
 * MathServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.cts.service;

        /**
        *  MathServiceMessageReceiverInOut message receiver
        */

        public class MathServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        MathServiceSkeleton skel = (MathServiceSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("add".equals(methodName)){
                
                com.cts.math.ws.AddResponseE addResponse1 = null;
	                        com.cts.math.ws.AddE wrappedParam =
                                                             (com.cts.math.ws.AddE)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.cts.math.ws.AddE.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addResponse1 =
                                                   
                                                   
                                                         skel.add(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addResponse1, false, new javax.xml.namespace.QName("http://ws.math.cts.com/",
                                                    "add"));
                                    } else 

            if("subract".equals(methodName)){
                
                com.cts.math.ws.SubractResponseE subractResponse3 = null;
	                        com.cts.math.ws.SubractE wrappedParam =
                                                             (com.cts.math.ws.SubractE)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.cts.math.ws.SubractE.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               subractResponse3 =
                                                   
                                                   
                                                         skel.subract(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), subractResponse3, false, new javax.xml.namespace.QName("http://ws.math.cts.com/",
                                                    "subract"));
                                    } else 

            if("multiply".equals(methodName)){
                
                com.cts.math.ws.MultiplyResponseE multiplyResponse5 = null;
	                        com.cts.math.ws.MultiplyE wrappedParam =
                                                             (com.cts.math.ws.MultiplyE)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.cts.math.ws.MultiplyE.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               multiplyResponse5 =
                                                   
                                                   
                                                         skel.multiply(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), multiplyResponse5, false, new javax.xml.namespace.QName("http://ws.math.cts.com/",
                                                    "multiply"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(com.cts.math.ws.AddE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.cts.math.ws.AddE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.cts.math.ws.AddResponseE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.cts.math.ws.AddResponseE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.cts.math.ws.SubractE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.cts.math.ws.SubractE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.cts.math.ws.SubractResponseE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.cts.math.ws.SubractResponseE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.cts.math.ws.MultiplyE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.cts.math.ws.MultiplyE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.cts.math.ws.MultiplyResponseE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.cts.math.ws.MultiplyResponseE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.cts.math.ws.AddResponseE param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.cts.math.ws.AddResponseE.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.cts.math.ws.AddResponseE wrapadd(){
                                com.cts.math.ws.AddResponseE wrappedElement = new com.cts.math.ws.AddResponseE();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.cts.math.ws.SubractResponseE param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.cts.math.ws.SubractResponseE.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.cts.math.ws.SubractResponseE wrapsubract(){
                                com.cts.math.ws.SubractResponseE wrappedElement = new com.cts.math.ws.SubractResponseE();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.cts.math.ws.MultiplyResponseE param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.cts.math.ws.MultiplyResponseE.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.cts.math.ws.MultiplyResponseE wrapmultiply(){
                                com.cts.math.ws.MultiplyResponseE wrappedElement = new com.cts.math.ws.MultiplyResponseE();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.cts.math.ws.AddE.class.equals(type)){
                
                           return com.cts.math.ws.AddE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.cts.math.ws.AddResponseE.class.equals(type)){
                
                           return com.cts.math.ws.AddResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.cts.math.ws.SubractE.class.equals(type)){
                
                           return com.cts.math.ws.SubractE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.cts.math.ws.SubractResponseE.class.equals(type)){
                
                           return com.cts.math.ws.SubractResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.cts.math.ws.MultiplyE.class.equals(type)){
                
                           return com.cts.math.ws.MultiplyE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.cts.math.ws.MultiplyResponseE.class.equals(type)){
                
                           return com.cts.math.ws.MultiplyResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    