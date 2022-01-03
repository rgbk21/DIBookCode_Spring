package _3_InvestigatingDI.PartialInjection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import static com.google.common.base.Preconditions.checkNotNull;

public class DelivererFactoryImpl implements DelivererFactory, BeanFactoryAware {
  private BeanFactory beanFactory;

  @Override
  public Deliverer create(NewsLetter newsLetter, String date) {
    EmailService emailService = beanFactory.getBean(EmailService.class);
    return new Deliverer(emailService, newsLetter, date);
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = checkNotNull(beanFactory);
  }
}
