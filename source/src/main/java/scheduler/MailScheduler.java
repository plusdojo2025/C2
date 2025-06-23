package scheduler;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import dao.TblStockprefoodDao;
import dto.TblStockprefoodDto;
import utility.MailUtil; 


public class MailScheduler {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void start() {
        scheduler.scheduleAtFixedRate(() -> {
        	try {
                System.out.println("保存食メールリマインダーを実行中…");

                TblStockprefoodDao dao = new TblStockprefoodDao();

                List<Integer> userNumbers = dao.getAllUserNumbers(); 

                for (int userNumber : userNumbers) {
                    List<TblStockprefoodDto> items = dao.selectExpiringInDays(7, userNumber);
                    for (TblStockprefoodDto item : items) {
                        MailUtil.sendMail(item);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 24, TimeUnit.HOURS);

    }

}
