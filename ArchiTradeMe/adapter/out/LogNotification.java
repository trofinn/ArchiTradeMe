package adapter.out;

import application.port.out.Notification;

public final class LogNotification implements Notification {
    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
