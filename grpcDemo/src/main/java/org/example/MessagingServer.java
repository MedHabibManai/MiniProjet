package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MessagingServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(9090)
                .addService(new MessagingServiceImpl())
                .build();

        server.start();

        System.out.println("Server started");

        server.awaitTermination();
    }

    static class MessagingServiceImpl extends MessagingServiceGrpc.MessagingServiceImplBase {
        @Override
        public void sendMessage(Message request, StreamObserver<Message> responseObserver) {
            System.out.println("Received message: " + request.getText());


            Message response = Message.newBuilder()
                    .setSender("Server")
                    .setText("Message received")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
