
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package com.cts.math.ws;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://ws.math.cts.com/".equals(namespaceURI) &&
                  "multiplyResponse".equals(typeName)){
                   
                            return  com.cts.math.ws.MultiplyResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.math.cts.com/".equals(namespaceURI) &&
                  "addResponse".equals(typeName)){
                   
                            return  com.cts.math.ws.AddResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.math.cts.com/".equals(namespaceURI) &&
                  "subractResponse".equals(typeName)){
                   
                            return  com.cts.math.ws.SubractResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.math.cts.com/".equals(namespaceURI) &&
                  "add".equals(typeName)){
                   
                            return  com.cts.math.ws.Add.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.math.cts.com/".equals(namespaceURI) &&
                  "subract".equals(typeName)){
                   
                            return  com.cts.math.ws.Subract.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.math.cts.com/".equals(namespaceURI) &&
                  "multiply".equals(typeName)){
                   
                            return  com.cts.math.ws.Multiply.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    