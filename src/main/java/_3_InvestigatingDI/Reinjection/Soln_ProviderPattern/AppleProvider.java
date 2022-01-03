package _3_InvestigatingDI.Reinjection.Soln_ProviderPattern;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import static com.google.common.base.Preconditions.checkNotNull;

public class AppleProvider implements Provider<Apple>, BeanFactoryAware {
  private BeanFactory injector;

  @Override
  public Apple get() {
    return (Apple) injector.getBean("beans.apple");
  }

  @Override
  public void setBeanFactory(BeanFactory injector) throws BeansException {
    this.injector = checkNotNull(injector);
  }
}
