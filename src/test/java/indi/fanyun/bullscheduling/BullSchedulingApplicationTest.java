package indi.fanyun.bullscheduling;

/**
 * @author tshk
 * @date 2021-01-14 16:12
 */
public class BullSchedulingApplicationTest {
    public static void main(String[] args) {
        System.setProperty( "mybatis.configuration.log-impl", "org.apache.ibatis.logging.stdout.StdOutImpl" );
        BullSchedulingApplication.main(args);
    }
}
