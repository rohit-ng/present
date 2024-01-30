package dev.infraspec.DependencyInversion.With;

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

class NotificationService {
    private final MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotification(String message) {

        messageService.sendMessage(message);
    }
}

class Main {
    public static void main(String[] args) {
        MessageService emailService = new EmailService();

        NotificationService notificationService = new NotificationService(emailService);

        notificationService.sendNotification("Hello, this is an email notification!");
    }
}
