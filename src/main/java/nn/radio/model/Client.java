package nn.radio.model;

import java.io.*;
import java.net.Socket;

public class Client {
    public DTO begin(Tank tank, DTO dtoOut) throws Exception {
        Socket socket = new Socket("localhost", 3010);
        System.out.println("### socket: " + socket);

//        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            ObjectInputStream ois = new ObjectInputStream(in);
            ObjectOutputStream oos = new ObjectOutputStream(out);

            oos.writeObject(dtoOut);

            DTO dtoIn = (DTO) ois.readObject();
            tank.A = dtoIn.A;
            System.out.printf("приняли в ответ dtoIn.deltaX = %s\n", dtoIn.deltaX);
            System.out.printf("приняли в ответ dtoIn.deltaY = %s\n", dtoIn.deltaY);
            return dtoIn;
//            ois.close();
//            oos.close();

//        } finally {
//            System.out.println("closing...");
////            socket.close();
//        }
    }
}