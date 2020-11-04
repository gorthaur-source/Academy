import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

public class HostName {

    public static void main(String[] args) {


        try {


         //   System.out.println(InetAddress.getByName("kotaku.com").isReachable(50));

          /*  int[] ip = new int[]{186, 192, 81, 5};
            byte[] ipAddress = new byte[4];

            for(int i = 0; i < ipAddress.length; i++) {
                ipAddress[i] = (byte) ip[i];
            }

            InetAddress globoIP = InetAddress.getByAddress(ipAddress);
            System.out.println(globoIP.isReachable(500));
            System.out.println(globoIP.getCanonicalHostName());
            */
            String ipProcessed = "";

            for (int i = 0; i<args.length; i++) {
                String[] ipArray = args[i].split(".");
                System.out.println(Arrays.toString(ipArray));
                if (ipArray.length == 4) {
                    System.out.println("reach");
                    for (int j = 0; j < ipArray.length; j++) {
                        int ipPart = Integer.parseInt(ipArray[i]);
                        if (ipPart >= 0 && ipPart < 256) {
                            ipProcessed += ipArray[i] + ".";
                            System.out.println(ipProcessed);
                        } else break;

                    }
                }
            }
            for (String arg : args) {

                InetAddress address = InetAddress.getByName(arg);
                System.out.println("The site and correspondent IP address is :" + address + "\n -----------------------------");
                System.out.println("Site reachability: " + address.isReachable(500));
            }

        } catch (UnknownHostException e) {
            System.out.println("Host not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
