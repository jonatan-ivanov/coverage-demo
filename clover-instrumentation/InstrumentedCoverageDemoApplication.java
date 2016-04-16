//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example;

import com_atlassian_clover.Clover;
import com_atlassian_clover.CloverProfile;
import com_atlassian_clover.CloverVersionInfo;
import com_atlassian_clover.CoverageRecorder;
import com_atlassian_clover.TestNameSniffer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoverageDemoApplication {
    public static final TestNameSniffer __CLR4_1_1_TEST_NAME_SNIFFER;

    public CoverageDemoApplication() {
    }

    public static void main(String[] var0) {
        CoverageDemoApplication.__CLR4_1_144in3j646t.R.inc(4);
        CoverageDemoApplication.__CLR4_1_144in3j646t.R.inc(5);
        SpringApplication.run(CoverageDemoApplication.class, var0);
    }

    static {
        __CLR4_1_1_TEST_NAME_SNIFFER = TestNameSniffer.NULL_INSTANCE;
    }

    public static class __CLR4_1_144in3j646t {
        public static CoverageRecorder R;
        public static CloverProfile[] profiles = new CloverProfile[0];

        public __CLR4_1_144in3j646t() {
        }

        public static <I, T extends I> I lambdaInc(final int var0, final T var1, final int var2) {
            InvocationHandler var3 = new InvocationHandler() {
                public Object invoke(Object var1x, Method var2x, Object[] var3) throws Throwable {
                    CoverageDemoApplication.__CLR4_1_144in3j646t.R.inc(var0);
                    CoverageDemoApplication.__CLR4_1_144in3j646t.R.inc(var2);

                    try {
                        return var2x.invoke(var1, var3);
                    } catch (InvocationTargetException var5) {
                        throw (Throwable)(var5.getCause() != null?var5.getCause():new RuntimeException("Clover failed to invoke instrumented lambda", var5));
                    }
                }
            };
            return Proxy.newProxyInstance(var1.getClass().getClassLoader(), var1.getClass().getInterfaces(), var3);
        }

        static {
            CoverageRecorder var0 = null;

            try {
                CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_1_1();
                if(20151207095404243L != CloverVersionInfo.getBuildStamp()) {
                    Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");
                    Clover.l("[CLOVER] WARNING: Instr=4.1.1#20151207095404243,Runtime=" + CloverVersionInfo.getReleaseNum() + "#" + CloverVersionInfo.getBuildStamp());
                }

                R = Clover.getNullRecorder();
                var0 = Clover.getNullRecorder();
                var0 = Clover.getRecorder("/Users/v-jivanov/dev/GitHub/coverage-demo/build/.clover/clover.db-test", 1460834543980L, 0L, 6, profiles, new String[]{"clover.distributed.coverage", null});
            } catch (SecurityException var2) {
                System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. (" + var2.getClass() + ":" + var2.getMessage() + ")");
            } catch (NoClassDefFoundError var3) {
                System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? (" + var3.getClass() + ":" + var3.getMessage() + ")");
            } catch (Throwable var4) {
                System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. (" + var4.getClass() + ":" + var4.getMessage() + ")");
            }

            R = var0;
        }
    }
}
