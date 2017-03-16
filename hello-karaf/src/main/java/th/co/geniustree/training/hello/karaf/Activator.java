package th.co.geniustree.training.hello.karaf;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        System.out.println("Hello Karaf");
    }

    public void stop(BundleContext context) throws Exception {
         System.out.println("Goodbye Karaf");
    }

}
