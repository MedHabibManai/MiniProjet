ChatRoom:
1Compile and Run the Server then the client (client can be ran as many times as you want utilizing Multithreading)

TaskList:
1.  Run the rmiregistry using the cmd/terminal
2.  Compiler the interface
3.  Compiler and Run the server then the client :
  Choose between the available Methods to modify the list

MessagerieGRPC:
1.  Create a Maven project:
2.  Generate the Java Classes from the Protobuf Definition (gRPC plugin and protoc must be installed prior)
  using the following command (change the path) protoc --plugin=protoc-gen-grpc-java=/path/to/protoc-gen-grpc-java --grpc-java_out=. --java_out=. messages.proto
3.  Compile and run both the server then client implemenation 
 
