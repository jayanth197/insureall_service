set +x
LocalWorkspace=${WORKSPACE}
WARFilePath="$LocalWorkspace/target/insureall-service.war
echo "WAR File Path is ( Source path from the server) : $WARFilePath"

foldername="Insureall-Service-$(date +"%d-%m-%Y-%H-%M-%S")"
mkdir -p "$LocalWorkspace/target/insureall-service.war/$foldername"
echo "Folder is created"

echo "Starting - copying file from $WARFilePath to $LocalWorkspace/target/insureall-service.war/$foldername/"
cp $WARFilePath "$LocalWorkspace/target/insureall-service.war/$foldername/"
echo "Completed - copying file from $WARFilePath to $LocalWorkspace/target/insureall-service.war/$foldername/"

cd "$LocalWorkspace/target/insureall-service.war/"
echo "Starting - Upload folder to S3 bucket"
/usr/local/bin/aws s3 cp $foldername "s3://insureall/Builds/Insureall//$foldername/" --recursive
echo "Completed - Upload folder to S3 bucket"
