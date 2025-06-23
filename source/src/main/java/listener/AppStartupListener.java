package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import scheduler.MailScheduler;

@WebListener
public class AppStartupListener implements ServletContextListener {

	    @Override
	    public void contextInitialized(ServletContextEvent sce) {
	        System.out.println("📡 アプリ起動 → MailSchedulerスタート");
	        MailScheduler.start();
	    }

	    @Override
	    public void contextDestroyed(ServletContextEvent sce) {
	        // アプリ終了時の処理（必要があれば書く）
	    }
	}

