package com.integra.contabilidad.wsseguridad.servicio.impl;

import com.integra.contabilidad.util.Propiedades;

public class SeguridadImplStub extends org.apache.axis2.client.Stub {
	
	protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;
    
    private static synchronized java.lang.String getUniqueSuffix(){
        // reset the counter if it is greater than 99999
        if (counter > 99999){
            counter = 0;
        }
        counter = counter + 1; 
        return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {

        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("SeguridadImpl" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[3];

        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com", "obtenerInfoSesion"));
        _service.addOperation(__operation);




        _operations[0]=__operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com", "listarMenuAplicativo"));
        _service.addOperation(__operation);




        _operations[1]=__operation;


        __operation = new org.apache.axis2.description.OutOnlyAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com", "setSeguridadDao"));
        _service.addOperation(__operation);




        _operations[2]=__operation;


    }

    //populates the faults
    private void populateFaults(){



    }

    /**
     *Constructor that takes in a configContext
     */

    public SeguridadImplStub(org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint)
    throws org.apache.axis2.AxisFault {
        this(configurationContext,targetEndpoint,false);
    }


    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public SeguridadImplStub(org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint, boolean useSeparateListener)
    throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);


        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);


    }

    /**
     * Default Constructor
     */
    public SeguridadImplStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
    	this(configurationContext, Propiedades.getUrlSeguridadServicio());
    }

    /**
     * Default Constructor
     */
    public SeguridadImplStub() throws org.apache.axis2.AxisFault {
        this(Propiedades.getUrlSeguridadServicio());
    }

    /**
     * Constructor taking the target endpoint
     */
    public SeguridadImplStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }




    /**
     * Auto generated method signature
     * 
     * @see com.integra.wsseguridad.servicio.impl.SeguridadImpl#obtenerInfoSesion
     * @param obtenerInfoSesion0

     */



    public  com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse obtenerInfoSesion(

            com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesion obtenerInfoSesion0)


    throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try{
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("urn:ObtenerInfoSesion");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



            addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();



            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    obtenerInfoSesion0,
                    optimizeContent(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                    "obtenerInfoSesion")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement() ,
                    com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse)object;

        }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                            (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     * 
     * @see com.integra.wsseguridad.servicio.impl.SeguridadImpl#startobtenerInfoSesion
     * @param obtenerInfoSesion0

     */
    public  void startobtenerInfoSesion(

            com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesion obtenerInfoSesion0,

            final com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplCallbackHandler callback)

    throws java.rmi.RemoteException{

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
        _operationClient.getOptions().setAction("urn:ObtenerInfoSesion");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



        addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env=null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                obtenerInfoSesion0,
                optimizeContent(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                "obtenerInfoSesion")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultobtenerInfoSesion(
                            (com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse)object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorobtenerInfoSesion(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt!=null){
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                            //make the fault by reflection
                            try{
                                java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex=
                                    (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex,new java.lang.Object[]{messageObject});


                                callback.receiveErrorobtenerInfoSesion(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch(java.lang.ClassCastException e){
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorobtenerInfoSesion(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorobtenerInfoSesion(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorobtenerInfoSesion(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorobtenerInfoSesion(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorobtenerInfoSesion(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorobtenerInfoSesion(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorobtenerInfoSesion(f);
                            }
                        } else {
                            callback.receiveErrorobtenerInfoSesion(f);
                        }
                    } else {
                        callback.receiveErrorobtenerInfoSesion(f);
                    }
                } else {
                    callback.receiveErrorobtenerInfoSesion(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorobtenerInfoSesion(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     * 
     * @see com.integra.wsseguridad.servicio.impl.SeguridadImpl#listarMenuAplicativo
     * @param listarMenuAplicativo2

     */



    public  com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse listarMenuAplicativo(
            com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativo listarMenuAplicativo2)
    throws java.rmi.RemoteException                    
    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try{
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions().setAction("urn:ListarMenuAplicativo");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    listarMenuAplicativo2,
                    optimizeContent(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                    "listarMenuAplicativo")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement() ,
                    com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse)object;

        }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                            (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     * 
     * @see com.integra.wsseguridad.servicio.impl.SeguridadImpl#startlistarMenuAplicativo
     * @param listarMenuAplicativo2

     */
    public  void startlistarMenuAplicativo(

            com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativo listarMenuAplicativo2,

            final com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplCallbackHandler callback)

    throws java.rmi.RemoteException{

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
        _operationClient.getOptions().setAction("urn:ListarMenuAplicativo");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



        addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env=null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                listarMenuAplicativo2,
                optimizeContent(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                "listarMenuAplicativo")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultlistarMenuAplicativo(
                            (com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse)object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorlistarMenuAplicativo(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt!=null){
                        if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                            //make the fault by reflection
                            try{
                                java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.Exception ex=
                                    (java.lang.Exception) exceptionClass.newInstance();
                                //message class
                                java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex,new java.lang.Object[]{messageObject});


                                callback.receiveErrorlistarMenuAplicativo(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch(java.lang.ClassCastException e){
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlistarMenuAplicativo(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlistarMenuAplicativo(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlistarMenuAplicativo(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlistarMenuAplicativo(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlistarMenuAplicativo(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlistarMenuAplicativo(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlistarMenuAplicativo(f);
                            }
                        } else {
                            callback.receiveErrorlistarMenuAplicativo(f);
                        }
                    } else {
                        callback.receiveErrorlistarMenuAplicativo(f);
                    }
                } else {
                    callback.receiveErrorlistarMenuAplicativo(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorlistarMenuAplicativo(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[1].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }


    /**
     * Auto generated method signature
     * 
     */
    public void  setSeguridadDao(
            com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.SetSeguridadDao setSeguridadDao4

    ) throws java.rmi.RemoteException


    {
        org.apache.axis2.context.MessageContext _messageContext = null;


        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
        _operationClient.getOptions().setAction("urn:setSeguridadDao");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



        addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");

        org.apache.axiom.soap.SOAPEnvelope env = null;
        _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                setSeguridadDao4,
                optimizeContent(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                "setSeguridadDao")));


        //adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope

        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.execute(true);


        if (_messageContext.getTransportOut() != null) {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }

        return;
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



    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {


        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
    //http://sdpeapp00024:9081/WSSeguridad/services/SeguridadImpl.SeguridadImplHttpSoap11Endpoint/
    public static class ObtenerInfoSesion
    implements org.apache.axis2.databinding.ADBBean{

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://impl.servicio.wsseguridad.integra.com",
                "ObtenerInfoSesion",
        "ns1");



        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://impl.servicio.wsseguridad.integra.com")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



        /**
         * field for TokenSesion
         */


        protected java.lang.String localTokenSesion ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localTokenSesionTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getTokenSesion(){
            return localTokenSesion;
        }



        /**
         * Auto generated setter method
         * @param param TokenSesion
         */
        public void setTokenSesion(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localTokenSesionTracker = true;
            } else {
                localTokenSesionTracker = true;

            }

            this.localTokenSesion=param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try{
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            }catch(java.lang.IllegalArgumentException e){
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement (
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ObtenerInfoSesion.this.serialize(MY_QNAME,factory,xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME,factory,dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            serialize(parentQName,factory,xmlWriter,false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType){


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://impl.servicio.wsseguridad.integra.com");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            namespacePrefix+":ObtenerInfoSesion",
                            xmlWriter);
                } else {
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            "ObtenerInfoSesion",
                            xmlWriter);
                }


            }
            if (localTokenSesionTracker){
                namespace = "http://impl.servicio.wsseguridad.integra.com";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"tokenSesion", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"tokenSesion");
                    }

                } else {
                    xmlWriter.writeStartElement("tokenSesion");
                }


                if (localTokenSesion==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localTokenSesion);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace,attName,attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals(""))
            {
                xmlWriter.writeAttribute(attName,attValue);
            }
            else
            {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }



        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException{



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localTokenSesionTracker){
                elementList.add(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                "tokenSesion"));

                elementList.add(localTokenSesion==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTokenSesion));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory{




            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ObtenerInfoSesion parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
                ObtenerInfoSesion object =
                    new ObtenerInfoSesion();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix ="";
                java.lang.String namespaceuri ="";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                        if (fullTypeName!=null){
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1){
                                nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix==null?"":nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"ObtenerInfoSesion".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ObtenerInfoSesion)ExtensionMapper.getTypeObject(
                                        nsUri,type,reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com","tokenSesion").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setTokenSesion(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class



    }


    public static class ExtensionMapper{

        public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                java.lang.String typeName,
                javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{


            if (
                    "http://bean.seguridad.wsseguridad.integra.com/xsd".equals(namespaceURI) &&
                    "ResultListarMenuAplicativoBean".equals(typeName)){

                return  ResultListarMenuAplicativoBean.Factory.parse(reader);


            }


            if (
                    "http://bean.seguridad.wsseguridad.integra.com/xsd".equals(namespaceURI) &&
                    "ResultObtenerInfoSesionBean".equals(typeName)){

                return  ResultObtenerInfoSesionBean.Factory.parse(reader);


            }


            if (
                    "http://dao.seguridad.wsseguridad.integra.com/xsd".equals(namespaceURI) &&
                    "SeguridadDao".equals(typeName)){

                return  SeguridadDao.Factory.parse(reader);


            }


            throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }

    }

    public static class ListarMenuAplicativo
    implements org.apache.axis2.databinding.ADBBean{

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://impl.servicio.wsseguridad.integra.com",
                "ListarMenuAplicativo",
        "ns1");



        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://impl.servicio.wsseguridad.integra.com")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



        /**
         * field for TokenSesion
         */


        protected java.lang.String localTokenSesion ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localTokenSesionTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getTokenSesion(){
            return localTokenSesion;
        }



        /**
         * Auto generated setter method
         * @param param TokenSesion
         */
        public void setTokenSesion(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localTokenSesionTracker = true;
            } else {
                localTokenSesionTracker = true;

            }

            this.localTokenSesion=param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try{
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            }catch(java.lang.IllegalArgumentException e){
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement (
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ListarMenuAplicativo.this.serialize(MY_QNAME,factory,xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME,factory,dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            serialize(parentQName,factory,xmlWriter,false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType){


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://impl.servicio.wsseguridad.integra.com");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            namespacePrefix+":ListarMenuAplicativo",
                            xmlWriter);
                } else {
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            "ListarMenuAplicativo",
                            xmlWriter);
                }


            }
            if (localTokenSesionTracker){
                namespace = "http://impl.servicio.wsseguridad.integra.com";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"tokenSesion", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"tokenSesion");
                    }

                } else {
                    xmlWriter.writeStartElement("tokenSesion");
                }


                if (localTokenSesion==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localTokenSesion);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace,attName,attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals(""))
            {
                xmlWriter.writeAttribute(attName,attValue);
            }
            else
            {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }



        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException{



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localTokenSesionTracker){
                elementList.add(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                "tokenSesion"));

                elementList.add(localTokenSesion==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTokenSesion));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory{




            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListarMenuAplicativo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
                ListarMenuAplicativo object =
                    new ListarMenuAplicativo();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix ="";
                java.lang.String namespaceuri ="";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                        if (fullTypeName!=null){
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1){
                                nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix==null?"":nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"ListarMenuAplicativo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ListarMenuAplicativo)ExtensionMapper.getTypeObject(
                                        nsUri,type,reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com","tokenSesion").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setTokenSesion(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class



    }


    public static class ResultListarMenuAplicativoBean
    implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ResultListarMenuAplicativoBean
                Namespace URI = http://bean.seguridad.wsseguridad.integra.com/xsd
                Namespace Prefix = ns2
         */


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://bean.seguridad.wsseguridad.integra.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



        /**
         * field for CodOpcionMenu
         */


        protected java.lang.String localCodOpcionMenu ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localCodOpcionMenuTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getCodOpcionMenu(){
            return localCodOpcionMenu;
        }



        /**
         * Auto generated setter method
         * @param param CodOpcionMenu
         */
        public void setCodOpcionMenu(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localCodOpcionMenuTracker = true;
            } else {
                localCodOpcionMenuTracker = true;

            }

            this.localCodOpcionMenu=param;


        }


        /**
         * field for CodOpcionMenuPadre
         */


        protected java.lang.String localCodOpcionMenuPadre ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localCodOpcionMenuPadreTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getCodOpcionMenuPadre(){
            return localCodOpcionMenuPadre;
        }



        /**
         * Auto generated setter method
         * @param param CodOpcionMenuPadre
         */
        public void setCodOpcionMenuPadre(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localCodOpcionMenuPadreTracker = true;
            } else {
                localCodOpcionMenuPadreTracker = true;

            }

            this.localCodOpcionMenuPadre=param;


        }


        /**
         * field for DescEstado
         */


        protected java.lang.String localDescEstado ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localDescEstadoTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getDescEstado(){
            return localDescEstado;
        }



        /**
         * Auto generated setter method
         * @param param DescEstado
         */
        public void setDescEstado(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localDescEstadoTracker = true;
            } else {
                localDescEstadoTracker = true;

            }

            this.localDescEstado=param;


        }


        /**
         * field for Estado
         */


        protected java.lang.String localEstado ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localEstadoTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getEstado(){
            return localEstado;
        }



        /**
         * Auto generated setter method
         * @param param Estado
         */
        public void setEstado(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localEstadoTracker = true;
            } else {
                localEstadoTracker = true;

            }

            this.localEstado=param;


        }


        /**
         * field for Open
         */


        protected java.lang.String localOpen ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localOpenTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getOpen(){
            return localOpen;
        }



        /**
         * Auto generated setter method
         * @param param Open
         */
        public void setOpen(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localOpenTracker = true;
            } else {
                localOpenTracker = true;

            }

            this.localOpen=param;


        }


        /**
         * field for TituloOpcionMenu
         */


        protected java.lang.String localTituloOpcionMenu ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localTituloOpcionMenuTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getTituloOpcionMenu(){
            return localTituloOpcionMenu;
        }



        /**
         * Auto generated setter method
         * @param param TituloOpcionMenu
         */
        public void setTituloOpcionMenu(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localTituloOpcionMenuTracker = true;
            } else {
                localTituloOpcionMenuTracker = true;

            }

            this.localTituloOpcionMenu=param;


        }


        /**
         * field for Url
         */


        protected java.lang.String localUrl ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localUrlTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getUrl(){
            return localUrl;
        }



        /**
         * Auto generated setter method
         * @param param Url
         */
        public void setUrl(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localUrlTracker = true;
            } else {
                localUrlTracker = true;

            }

            this.localUrl=param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try{
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            }catch(java.lang.IllegalArgumentException e){
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement (
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ResultListarMenuAplicativoBean.this.serialize(parentQName,factory,xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    parentQName,factory,dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            serialize(parentQName,factory,xmlWriter,false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType){


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://bean.seguridad.wsseguridad.integra.com/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            namespacePrefix+":ResultListarMenuAplicativoBean",
                            xmlWriter);
                } else {
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            "ResultListarMenuAplicativoBean",
                            xmlWriter);
                }


            }
            if (localCodOpcionMenuTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"codOpcionMenu", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"codOpcionMenu");
                    }

                } else {
                    xmlWriter.writeStartElement("codOpcionMenu");
                }


                if (localCodOpcionMenu==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localCodOpcionMenu);

                }

                xmlWriter.writeEndElement();
            } if (localCodOpcionMenuPadreTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"codOpcionMenuPadre", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"codOpcionMenuPadre");
                    }

                } else {
                    xmlWriter.writeStartElement("codOpcionMenuPadre");
                }


                if (localCodOpcionMenuPadre==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localCodOpcionMenuPadre);

                }

                xmlWriter.writeEndElement();
            } if (localDescEstadoTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"descEstado", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"descEstado");
                    }

                } else {
                    xmlWriter.writeStartElement("descEstado");
                }


                if (localDescEstado==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localDescEstado);

                }

                xmlWriter.writeEndElement();
            } if (localEstadoTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"estado", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"estado");
                    }

                } else {
                    xmlWriter.writeStartElement("estado");
                }


                if (localEstado==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localEstado);

                }

                xmlWriter.writeEndElement();
            } if (localOpenTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"open", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"open");
                    }

                } else {
                    xmlWriter.writeStartElement("open");
                }


                if (localOpen==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localOpen);

                }

                xmlWriter.writeEndElement();
            } if (localTituloOpcionMenuTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"tituloOpcionMenu", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"tituloOpcionMenu");
                    }

                } else {
                    xmlWriter.writeStartElement("tituloOpcionMenu");
                }


                if (localTituloOpcionMenu==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localTituloOpcionMenu);

                }

                xmlWriter.writeEndElement();
            } if (localUrlTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"url", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"url");
                    }

                } else {
                    xmlWriter.writeStartElement("url");
                }


                if (localUrl==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localUrl);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace,attName,attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals(""))
            {
                xmlWriter.writeAttribute(attName,attValue);
            }
            else
            {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }



        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException{



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localCodOpcionMenuTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "codOpcionMenu"));

                elementList.add(localCodOpcionMenu==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCodOpcionMenu));
            } if (localCodOpcionMenuPadreTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "codOpcionMenuPadre"));

                elementList.add(localCodOpcionMenuPadre==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCodOpcionMenuPadre));
            } if (localDescEstadoTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "descEstado"));

                elementList.add(localDescEstado==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescEstado));
            } if (localEstadoTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "estado"));

                elementList.add(localEstado==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEstado));
            } if (localOpenTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "open"));

                elementList.add(localOpen==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOpen));
            } if (localTituloOpcionMenuTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "tituloOpcionMenu"));

                elementList.add(localTituloOpcionMenu==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTituloOpcionMenu));
            } if (localUrlTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "url"));

                elementList.add(localUrl==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUrl));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory{




            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ResultListarMenuAplicativoBean parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
                ResultListarMenuAplicativoBean object =
                    new ResultListarMenuAplicativoBean();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix ="";
                java.lang.String namespaceuri ="";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                        if (fullTypeName!=null){
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1){
                                nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix==null?"":nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"ResultListarMenuAplicativoBean".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ResultListarMenuAplicativoBean)ExtensionMapper.getTypeObject(
                                        nsUri,type,reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","codOpcionMenu").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setCodOpcionMenu(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","codOpcionMenuPadre").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setCodOpcionMenuPadre(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","descEstado").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setDescEstado(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","estado").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setEstado(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","open").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setOpen(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","tituloOpcionMenu").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setTituloOpcionMenu(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","url").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setUrl(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class



    }


    public static class ResultObtenerInfoSesionBean
    implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ResultObtenerInfoSesionBean
                Namespace URI = http://bean.seguridad.wsseguridad.integra.com/xsd
                Namespace Prefix = ns2
         */


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://bean.seguridad.wsseguridad.integra.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



        /**
         * field for CodRol
         */


        protected java.lang.String localCodRol ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localCodRolTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getCodRol(){
            return localCodRol;
        }



        /**
         * Auto generated setter method
         * @param param CodRol
         */
        public void setCodRol(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localCodRolTracker = true;
            } else {
                localCodRolTracker = true;

            }

            this.localCodRol=param;


        }


        /**
         * field for CodUsuario
         */


        protected java.lang.String localCodUsuario ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localCodUsuarioTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getCodUsuario(){
            return localCodUsuario;
        }



        /**
         * Auto generated setter method
         * @param param CodUsuario
         */
        public void setCodUsuario(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localCodUsuarioTracker = true;
            } else {
                localCodUsuarioTracker = true;

            }

            this.localCodUsuario=param;


        }


        /**
         * field for FechaInicioSesion
         */


        protected java.lang.String localFechaInicioSesion ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localFechaInicioSesionTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getFechaInicioSesion(){
            return localFechaInicioSesion;
        }



        /**
         * Auto generated setter method
         * @param param FechaInicioSesion
         */
        public void setFechaInicioSesion(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localFechaInicioSesionTracker = true;
            } else {
                localFechaInicioSesionTracker = true;

            }

            this.localFechaInicioSesion=param;


        }


        /**
         * field for FechaInicioSesionTexto
         */


        protected java.lang.String localFechaInicioSesionTexto ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localFechaInicioSesionTextoTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getFechaInicioSesionTexto(){
            return localFechaInicioSesionTexto;
        }



        /**
         * Auto generated setter method
         * @param param FechaInicioSesionTexto
         */
        public void setFechaInicioSesionTexto(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localFechaInicioSesionTextoTracker = true;
            } else {
                localFechaInicioSesionTextoTracker = true;

            }

            this.localFechaInicioSesionTexto=param;


        }


        /**
         * field for NombreRol
         */


        protected java.lang.String localNombreRol ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localNombreRolTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getNombreRol(){
            return localNombreRol;
        }



        /**
         * Auto generated setter method
         * @param param NombreRol
         */
        public void setNombreRol(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localNombreRolTracker = true;
            } else {
                localNombreRolTracker = true;

            }

            this.localNombreRol=param;


        }


        /**
         * field for NombreUsuario
         */


        protected java.lang.String localNombreUsuario ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localNombreUsuarioTracker = false ;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public  java.lang.String getNombreUsuario(){
            return localNombreUsuario;
        }



        /**
         * Auto generated setter method
         * @param param NombreUsuario
         */
        public void setNombreUsuario(java.lang.String param){

            if (param != null){
                //update the setting tracker
                localNombreUsuarioTracker = true;
            } else {
                localNombreUsuarioTracker = true;

            }

            this.localNombreUsuario=param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try{
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            }catch(java.lang.IllegalArgumentException e){
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement (
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ResultObtenerInfoSesionBean.this.serialize(parentQName,factory,xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    parentQName,factory,dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            serialize(parentQName,factory,xmlWriter,false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType){


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://bean.seguridad.wsseguridad.integra.com/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            namespacePrefix+":ResultObtenerInfoSesionBean",
                            xmlWriter);
                } else {
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            "ResultObtenerInfoSesionBean",
                            xmlWriter);
                }


            }
            if (localCodRolTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"codRol", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"codRol");
                    }

                } else {
                    xmlWriter.writeStartElement("codRol");
                }


                if (localCodRol==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localCodRol);

                }

                xmlWriter.writeEndElement();
            } if (localCodUsuarioTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"codUsuario", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"codUsuario");
                    }

                } else {
                    xmlWriter.writeStartElement("codUsuario");
                }


                if (localCodUsuario==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localCodUsuario);

                }

                xmlWriter.writeEndElement();
            } if (localFechaInicioSesionTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"fechaInicioSesion", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"fechaInicioSesion");
                    }

                } else {
                    xmlWriter.writeStartElement("fechaInicioSesion");
                }


                if (localFechaInicioSesion==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localFechaInicioSesion);

                }

                xmlWriter.writeEndElement();
            } if (localFechaInicioSesionTextoTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"fechaInicioSesionTexto", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"fechaInicioSesionTexto");
                    }

                } else {
                    xmlWriter.writeStartElement("fechaInicioSesionTexto");
                }


                if (localFechaInicioSesionTexto==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localFechaInicioSesionTexto);

                }

                xmlWriter.writeEndElement();
            } if (localNombreRolTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"nombreRol", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"nombreRol");
                    }

                } else {
                    xmlWriter.writeStartElement("nombreRol");
                }


                if (localNombreRol==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localNombreRol);

                }

                xmlWriter.writeEndElement();
            } if (localNombreUsuarioTracker){
                namespace = "http://bean.seguridad.wsseguridad.integra.com/xsd";
                if (! namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix,"nombreUsuario", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace,"nombreUsuario");
                    }

                } else {
                    xmlWriter.writeStartElement("nombreUsuario");
                }


                if (localNombreUsuario==null){
                    // write the nil attribute

                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                }else{


                    xmlWriter.writeCharacters(localNombreUsuario);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace,attName,attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals(""))
            {
                xmlWriter.writeAttribute(attName,attValue);
            }
            else
            {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }



        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException{



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localCodRolTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "codRol"));

                elementList.add(localCodRol==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCodRol));
            } if (localCodUsuarioTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "codUsuario"));

                elementList.add(localCodUsuario==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCodUsuario));
            } if (localFechaInicioSesionTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "fechaInicioSesion"));

                elementList.add(localFechaInicioSesion==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFechaInicioSesion));
            } if (localFechaInicioSesionTextoTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "fechaInicioSesionTexto"));

                elementList.add(localFechaInicioSesionTexto==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFechaInicioSesionTexto));
            } if (localNombreRolTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "nombreRol"));

                elementList.add(localNombreRol==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNombreRol));
            } if (localNombreUsuarioTracker){
                elementList.add(new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd",
                "nombreUsuario"));

                elementList.add(localNombreUsuario==null?null:
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNombreUsuario));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory{




            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ResultObtenerInfoSesionBean parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
                ResultObtenerInfoSesionBean object =
                    new ResultObtenerInfoSesionBean();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix ="";
                java.lang.String namespaceuri ="";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                        if (fullTypeName!=null){
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1){
                                nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix==null?"":nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"ResultObtenerInfoSesionBean".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ResultObtenerInfoSesionBean)ExtensionMapper.getTypeObject(
                                        nsUri,type,reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","codRol").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setCodRol(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","codUsuario").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setCodUsuario(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","fechaInicioSesion").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setFechaInicioSesion(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","fechaInicioSesionTexto").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setFechaInicioSesionTexto(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","nombreRol").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setNombreRol(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://bean.seguridad.wsseguridad.integra.com/xsd","nombreUsuario").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                            java.lang.String content = reader.getElementText();

                            object.setNombreUsuario(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {


                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class



    }


    public static class ListarMenuAplicativoResponse
    implements org.apache.axis2.databinding.ADBBean{

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://impl.servicio.wsseguridad.integra.com",
                "ListarMenuAplicativoResponse",
        "ns1");



        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://impl.servicio.wsseguridad.integra.com")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



        /**
         * field for _return
         * This was an Array!
         */


        protected ResultListarMenuAplicativoBean[] local_return ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean local_returnTracker = false ;


        /**
         * Auto generated getter method
         * @return ResultListarMenuAplicativoBean[]
         */
        public  ResultListarMenuAplicativoBean[] get_return(){
            return local_return;
        }






        /**
         * validate the array for _return
         */
        protected void validate_return(ResultListarMenuAplicativoBean[] param){

        }


        /**
         * Auto generated setter method
         * @param param _return
         */
        public void set_return(ResultListarMenuAplicativoBean[] param){

            validate_return(param);


            if (param != null){
                //update the setting tracker
                local_returnTracker = true;
            } else {
                local_returnTracker = true;

            }

            this.local_return=param;
        }



        /**
         * Auto generated add method for the array for convenience
         * @param param ResultListarMenuAplicativoBean
         */
        public void add_return(ResultListarMenuAplicativoBean param){
            if (local_return == null){
                local_return = new ResultListarMenuAplicativoBean[]{};
            }


            //update the setting tracker
            local_returnTracker = true;


            java.util.List list =
                org.apache.axis2.databinding.utils.ConverterUtil.toList(local_return);
            list.add(param);
            this.local_return =
                (ResultListarMenuAplicativoBean[])list.toArray(
                        new ResultListarMenuAplicativoBean[list.size()]);

        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try{
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            }catch(java.lang.IllegalArgumentException e){
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement (
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ListarMenuAplicativoResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME,factory,dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            serialize(parentQName,factory,xmlWriter,false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType){


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://impl.servicio.wsseguridad.integra.com");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            namespacePrefix+":ListarMenuAplicativoResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            "ListarMenuAplicativoResponse",
                            xmlWriter);
                }


            }
            if (local_returnTracker){
                if (local_return!=null){
                    for (int i = 0;i < local_return.length;i++){
                        if (local_return[i] != null){
                            local_return[i].serialize(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com","return"),
                                    factory,xmlWriter);
                        } else {

                            // write null attribute
                            java.lang.String namespace2 = "http://impl.servicio.wsseguridad.integra.com";
                            if (! namespace2.equals("")) {
                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                if (prefix2 == null) {
                                    prefix2 = generatePrefix(namespace2);

                                    xmlWriter.writeStartElement(prefix2,"return", namespace2);
                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                    xmlWriter.setPrefix(prefix2, namespace2);

                                } else {
                                    xmlWriter.writeStartElement(namespace2,"return");
                                }

                            } else {
                                xmlWriter.writeStartElement("return");
                            }

                            // write the nil attribute
                            writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                            xmlWriter.writeEndElement();

                        }

                    }
                } else {

                    // write null attribute
                    java.lang.String namespace2 = "http://impl.servicio.wsseguridad.integra.com";
                    if (! namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2,"return", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2,"return");
                        }

                    } else {
                        xmlWriter.writeStartElement("return");
                    }

                    // write the nil attribute
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                    xmlWriter.writeEndElement();

                }
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace,attName,attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals(""))
            {
                xmlWriter.writeAttribute(attName,attValue);
            }
            else
            {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }



        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException{



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (local_returnTracker){
                if (local_return!=null) {
                    for (int i = 0;i < local_return.length;i++){

                        if (local_return[i] != null){
                            elementList.add(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                            "return"));
                            elementList.add(local_return[i]);
                        } else {

                            elementList.add(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                            "return"));
                            elementList.add(null);

                        }

                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                    "return"));
                    elementList.add(local_return);

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory{




            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListarMenuAplicativoResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
                ListarMenuAplicativoResponse object =
                    new ListarMenuAplicativoResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix ="";
                java.lang.String namespaceuri ="";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                        if (fullTypeName!=null){
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1){
                                nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix==null?"":nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"ListarMenuAplicativoResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ListarMenuAplicativoResponse)ExtensionMapper.getTypeObject(
                                        nsUri,type,reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com","return").equals(reader.getName())){



                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                            list1.add(null);
                            reader.next();
                        } else {
                            list1.add(ResultListarMenuAplicativoBean.Factory.parse(reader));
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while(!loopDone1){
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()){
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com","return").equals(reader.getName())){

                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        list1.add(null);
                                        reader.next();
                                    } else {
                                        list1.add(ResultListarMenuAplicativoBean.Factory.parse(reader));
                                    }
                                }else{
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.set_return((ResultListarMenuAplicativoBean[])
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                        ResultListarMenuAplicativoBean.class,
                                        list1));

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class



    }


    public static class SetSeguridadDao
    implements org.apache.axis2.databinding.ADBBean{

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://impl.servicio.wsseguridad.integra.com",
                "setSeguridadDao",
        "ns1");



        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://impl.servicio.wsseguridad.integra.com")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



        /**
         * field for SeguridadDao
         */


        protected SeguridadDao localSeguridadDao ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localSeguridadDaoTracker = false ;


        /**
         * Auto generated getter method
         * @return SeguridadDao
         */
        public  SeguridadDao getSeguridadDao(){
            return localSeguridadDao;
        }



        /**
         * Auto generated setter method
         * @param param SeguridadDao
         */
        public void setSeguridadDao(SeguridadDao param){

            if (param != null){
                //update the setting tracker
                localSeguridadDaoTracker = true;
            } else {
                localSeguridadDaoTracker = true;

            }

            this.localSeguridadDao=param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try{
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            }catch(java.lang.IllegalArgumentException e){
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement (
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    SetSeguridadDao.this.serialize(MY_QNAME,factory,xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME,factory,dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            serialize(parentQName,factory,xmlWriter,false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType){


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://impl.servicio.wsseguridad.integra.com");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            namespacePrefix+":setSeguridadDao",
                            xmlWriter);
                } else {
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            "setSeguridadDao",
                            xmlWriter);
                }


            }
            if (localSeguridadDaoTracker){
                if (localSeguridadDao==null){

                    java.lang.String namespace2 = "http://impl.servicio.wsseguridad.integra.com";

                    if (! namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2,"seguridadDao", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2,"seguridadDao");
                        }

                    } else {
                        xmlWriter.writeStartElement("seguridadDao");
                    }


                    // write the nil attribute
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                    xmlWriter.writeEndElement();
                }else{
                    localSeguridadDao.serialize(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com","seguridadDao"),
                            factory,xmlWriter);
                }
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace,attName,attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals(""))
            {
                xmlWriter.writeAttribute(attName,attValue);
            }
            else
            {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }



        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException{



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localSeguridadDaoTracker){
                elementList.add(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                "seguridadDao"));


                elementList.add(localSeguridadDao==null?null:
                    localSeguridadDao);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory{




            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static SetSeguridadDao parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
                SetSeguridadDao object =
                    new SetSeguridadDao();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix ="";
                java.lang.String namespaceuri ="";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                        if (fullTypeName!=null){
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1){
                                nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix==null?"":nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"setSeguridadDao".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (SetSeguridadDao)ExtensionMapper.getTypeObject(
                                        nsUri,type,reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com","seguridadDao").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                            object.setSeguridadDao(null);
                            reader.next();

                            reader.next();

                        }else{

                            object.setSeguridadDao(SeguridadDao.Factory.parse(reader));

                            reader.next();
                        }
                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class



    }


    public static class SeguridadDao
    implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = SeguridadDao
                Namespace URI = http://dao.seguridad.wsseguridad.integra.com/xsd
                Namespace Prefix = ns3
         */


        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dao.seguridad.wsseguridad.integra.com/xsd")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try{
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            }catch(java.lang.IllegalArgumentException e){
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement (
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    SeguridadDao.this.serialize(parentQName,factory,xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    parentQName,factory,dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            serialize(parentQName,factory,xmlWriter,false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType){


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dao.seguridad.wsseguridad.integra.com/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            namespacePrefix+":SeguridadDao",
                            xmlWriter);
                } else {
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            "SeguridadDao",
                            xmlWriter);
                }


            }

            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace,attName,attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals(""))
            {
                xmlWriter.writeAttribute(attName,attValue);
            }
            else
            {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }



        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException{



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();



            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory{




            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static SeguridadDao parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
                SeguridadDao object =
                    new SeguridadDao();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix ="";
                java.lang.String namespaceuri ="";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                        if (fullTypeName!=null){
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1){
                                nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix==null?"":nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"SeguridadDao".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (SeguridadDao)ExtensionMapper.getTypeObject(
                                        nsUri,type,reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class



    }


    public static class ObtenerInfoSesionResponse
    implements org.apache.axis2.databinding.ADBBean{

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://impl.servicio.wsseguridad.integra.com",
                "ObtenerInfoSesionResponse",
        "ns1");



        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://impl.servicio.wsseguridad.integra.com")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



        /**
         * field for _return
         */


        protected ResultObtenerInfoSesionBean local_return ;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean local_returnTracker = false ;


        /**
         * Auto generated getter method
         * @return ResultObtenerInfoSesionBean
         */
        public  ResultObtenerInfoSesionBean get_return(){
            return local_return;
        }



        /**
         * Auto generated setter method
         * @param param _return
         */
        public void set_return(ResultObtenerInfoSesionBean param){

            if (param != null){
                //update the setting tracker
                local_returnTracker = true;
            } else {
                local_returnTracker = true;

            }

            this.local_return=param;


        }


        /**
         * isReaderMTOMAware
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try{
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            }catch(java.lang.IllegalArgumentException e){
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement (
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



            org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    ObtenerInfoSesionResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                }
            };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME,factory,dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            serialize(parentQName,factory,xmlWriter,false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType){


                java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://impl.servicio.wsseguridad.integra.com");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            namespacePrefix+":ObtenerInfoSesionResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                            "ObtenerInfoSesionResponse",
                            xmlWriter);
                }


            }
            if (local_returnTracker){
                if (local_return==null){

                    java.lang.String namespace2 = "http://impl.servicio.wsseguridad.integra.com";

                    if (! namespace2.equals("")) {
                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2,"return", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2,"return");
                        }

                    } else {
                        xmlWriter.writeStartElement("return");
                    }


                    // write the nil attribute
                    writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                    xmlWriter.writeEndElement();
                }else{
                    local_return.serialize(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com","return"),
                            factory,xmlWriter);
                }
            }
            xmlWriter.writeEndElement();


        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace,attName,attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals(""))
            {
                xmlWriter.writeAttribute(attName,attValue);
            }
            else
            {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }



        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException{



            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (local_returnTracker){
                elementList.add(new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com",
                "return"));


                elementList.add(local_return==null?null:
                    local_return);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory{




            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ObtenerInfoSesionResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
                ObtenerInfoSesionResponse object =
                    new ObtenerInfoSesionResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix ="";
                java.lang.String namespaceuri ="";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                        if (fullTypeName!=null){
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1){
                                nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix==null?"":nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"ObtenerInfoSesionResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ObtenerInfoSesionResponse)ExtensionMapper.getTypeObject(
                                        nsUri,type,reader);
                            }


                        }


                    }




                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://impl.servicio.wsseguridad.integra.com","return").equals(reader.getName())){

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                            object.set_return(null);
                            reader.next();

                            reader.next();

                        }else{

                            object.set_return(ResultObtenerInfoSesionBean.Factory.parse(reader));

                            reader.next();
                        }
                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class



    }


    private  org.apache.axiom.om.OMElement  toOM(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesion param, boolean optimizeContent)
    throws org.apache.axis2.AxisFault {


        try{
            return param.getOMElement(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesion.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch(org.apache.axis2.databinding.ADBException e){
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private  org.apache.axiom.om.OMElement  toOM(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse param, boolean optimizeContent)
    throws org.apache.axis2.AxisFault {


        try{
            return param.getOMElement(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch(org.apache.axis2.databinding.ADBException e){
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private  org.apache.axiom.om.OMElement  toOM(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativo param, boolean optimizeContent)
    throws org.apache.axis2.AxisFault {


        try{
            return param.getOMElement(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativo.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch(org.apache.axis2.databinding.ADBException e){
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private  org.apache.axiom.om.OMElement  toOM(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse param, boolean optimizeContent)
    throws org.apache.axis2.AxisFault {


        try{
            return param.getOMElement(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch(org.apache.axis2.databinding.ADBException e){
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private  org.apache.axiom.om.OMElement  toOM(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.SetSeguridadDao param, boolean optimizeContent)
    throws org.apache.axis2.AxisFault {


        try{
            return param.getOMElement(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.SetSeguridadDao.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch(org.apache.axis2.databinding.ADBException e){
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesion param, boolean optimizeContent)
    throws org.apache.axis2.AxisFault{


        try{

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesion.MY_QNAME,factory));
            return emptyEnvelope;
        } catch(org.apache.axis2.databinding.ADBException e){
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */



    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativo param, boolean optimizeContent)
    throws org.apache.axis2.AxisFault{


        try{

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativo.MY_QNAME,factory));
            return emptyEnvelope;
        } catch(org.apache.axis2.databinding.ADBException e){
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */



    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.SetSeguridadDao param, boolean optimizeContent)
    throws org.apache.axis2.AxisFault{


        try{

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.SetSeguridadDao.MY_QNAME,factory));
            return emptyEnvelope;
        } catch(org.apache.axis2.databinding.ADBException e){
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    /* methods to provide back word compatibility */




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

            if (com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesion.class.equals(type)){

                return com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesion.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse.class.equals(type)){

                return com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativo.class.equals(type)){

                return com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativo.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse.class.equals(type)){

                return com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.SetSeguridadDao.class.equals(type)){

                return com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.SetSeguridadDao.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }
}