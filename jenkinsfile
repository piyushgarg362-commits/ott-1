node {

    def deploymentDir = "${env.WORKSPACE}/deployment"
    def jarFile = "target/java-maven-cicd-1.0.0.jar"

    try {

        stage('Checkout') {
            echo 'Checking out source code...'

            checkout scm
        }

        stage('Build') {
            echo 'Compiling Java application...'

            sh 'mvn clean compile'
        }

        stage('Test') {
            echo 'Running unit tests...'

            sh 'mvn test'
        }

        stage('Package') {
            echo 'Creating JAR file...'

            sh 'mvn package -DskipTests'

            archiveArtifacts(
                artifacts: 'target/*.jar',
                fingerprint: true
            )
        }

        stage('Deploy') {

            echo 'Deploying application...'

            sh """
                mkdir -p '${deploymentDir}'

                cp '${jarFile}' '${deploymentDir}/'

                echo 'JAR deployed successfully.'
                ls -lh '${deploymentDir}/'
            """
        }

        stage('Post-Deployment Verification') {

            echo 'Verifying deployment...'

            sh """
                if [ -f '${deploymentDir}/java-maven-cicd-1.0.0.jar' ]; then
                    echo 'Deployment verification successful.'
                else
                    echo 'ERROR: JAR file was not deployed.'
                    exit 1
                fi

                echo 'Starting deployed application...'

                java -jar '${deploymentDir}/java-maven-cicd-1.0.0.jar' \
                    > '${deploymentDir}/application.log'

                echo 'Application output:'

                cat '${deploymentDir}/application.log'

                grep -q 'Hello from Java Maven CI/CD!' \
                    '${deploymentDir}/application.log'

                echo 'Application verification successful.'
            """
        }

        echo '======================================'
        echo 'CI/CD PIPELINE COMPLETED SUCCESSFULLY'
        echo '======================================'

    }

    catch (Exception e) {

        echo '======================================'
        echo 'CI/CD PIPELINE FAILED'
        echo '======================================'

        echo "Error: ${e.getMessage()}"

        throw e
    }
}
