package _3_InvestigatingDI.PartialInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkState;

public class NewsLetterManager {
  private final List<Recipient> recipients;
  private final DelivererFactory delivererFactory;

  NewsLetterManager(DelivererFactory delivererFactory) {
    this.recipients = new ArrayList<>();
    this.delivererFactory = delivererFactory;
  }

  public void send(NewsLetter newsLetter) {
    for (Recipient recipient : recipients) {
      Deliverer deliverer = delivererFactory.create(newsLetter, "01/01/2022");
      deliverer.deliverNewsLetterTo(recipient);

      checkState(Objects.equals(deliverer.getDate(), "01/01/2022"));
    }
  }

  public void addRecipient(Recipient recipient) {
    recipients.add(recipient);
  }
}

class Deliverer {
  private final EmailService emailService; // from the Injector
  private final NewsLetter newsLetter; // from the instance's creator
  private final String date; // from the instance's creator

  Deliverer(EmailService emailService, NewsLetter newsLetter, String date) {
    this.emailService = emailService;
    this.newsLetter = newsLetter;
    this.date = date;
  }

  public void deliverNewsLetterTo(Recipient recipient) {
    System.out.println("Sending newsletter to recipient: " + recipient);
  }
  public String getDate() {
    return date;
  }
}

class NewsLetter {}
class EmailService {}
class Recipient {}

class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(NewsLetterBeanConfig.class);
    context.refresh();

    NewsLetterManager newsLetterManager = context.getBean(NewsLetterManager.class);
    newsLetterManager.addRecipient(new Recipient());
    newsLetterManager.addRecipient(new Recipient());
    newsLetterManager.addRecipient(new Recipient());

    newsLetterManager.send(new NewsLetter());
  }
}