package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MessagingClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        MessagingServiceGrpc.MessagingServiceBlockingStub stub = MessagingServiceGrpc.newBlockingStub(channel);

        Message message = Message.newBuilder()
                .setSender("Hi Habib")
                .setRecipient("rayen")
                .setText("Hello Rayen!")
                .build();

        Message response = stub.sendMessage(message);

        System.out.println("Response from server: " + response.getText());

        channel.shutdown();
    }
}
