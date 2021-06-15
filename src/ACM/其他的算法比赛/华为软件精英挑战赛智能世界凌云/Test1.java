package ACM.其他的算法比赛.华为软件精英挑战赛智能世界凌云;

public class Test1 {

    /***
     第一行输入一个整数N表示可以采购的服务器类型数量
     N行每行描述一种服务器{{型号,cpu核,内存,硬件成本,能耗成本}}
     接下来一行一个整数,虚拟机的数量M
     M行描述虚拟机{{型号,cpu核,内存,是否双节点部署}}
     接下来一行包括整数T
     T天的域用户请求
     每天的数据 第一行包含R 表示R条用户请求
     R行表示每一条请求数据:add/del 虚拟机型号虚拟机ID del 虚拟机ID

     */

    public static void test1() {
        //用户输入-->先假设
        int N = 2;//第一行可以采购的服务器数量-->NV603, 92, 324, 53800, 500  用一个对象存储
        Server[] server = new Server[N];
        server[0].serverName = "NV603";
        server[0].serverCPU = 92;
        server[0].serverMemory = 324;
        server[0].serverHardwareFacility = 53800;
        server[0].serverEnergyFacility = 500;
        server[1].serverName = "NV604";
        server[1].serverCPU = 128;
        server[1].serverMemory = 512;
        server[1].serverHardwareFacility = 87800;
        server[1].serverEnergyFacility = 800;

        int M = 3;//型号, CPU 核数, 内存大小, 是否双节点部署
        Vmware[] vmware = new Vmware[M];
        vmware[0].vmwareName = "s3.small.1";
        vmware[0].vmwareCPU = 1;
        vmware[0].vmwareMomery = 1;
        vmware[0].vmwarePoint = 0;
        vmware[1].vmwareName = "c3.large.4";
        vmware[1].vmwareCPU = 2;
        vmware[1].vmwareMomery = 8;
        vmware[1].vmwarePoint = 0;
        vmware[2].vmwareName = "c3.8xlarge.2";
        vmware[2].vmwareCPU = 32;
        vmware[2].vmwareMomery = 64;
        vmware[2].vmwarePoint = 1;

        int T = 4;
        Request[] request = new Request[T];
        request[0].requestMethod = "del";
        request[0].vmwareID = 720103584;
        request[1].vmwareName = "add";
        request[1].vmwareName = "vm66P61";
        request[1].vmwareID = 887393159;
        request[2].vmwareName = "add";
        request[2].vmwareName = "vmL91F4";
        request[2].vmwareID = 998119741;
        request[3].requestMethod = "del";
        request[3].vmwareID = 616478793;

        //代码实现相应的功能

    }

    public static void main(String[] args) {

        test1();
    }


}
