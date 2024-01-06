#!groovy

def decidePipeline(Map configMap){
    application = configMap.get("application")
    //# here we are getting nodeJSVM
    switch(application) {
        case 'nodeJSVM':
            echo "application is Node JS and VM based"
            nodeJSVMCI(configMap)
            break
        case 'nodeJSEKS':
            echo "application is Node JS and EKS based"
            nodeJSEKS(configMap)
            break
        case 'JavaVM':
            javaVMCI(configMap)
            break
        default:
            error "Un recognised application"
            break
    }
}