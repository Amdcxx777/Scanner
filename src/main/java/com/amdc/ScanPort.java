package com.amdc;

import java.net.InetSocketAddress;
import java.net.Socket;
import static com.amdc.Main.*;

public class ScanPort extends Thread {
        private final int str;
        private final int stp;
        public ScanPort(int str, int stp) {
            this.str = str;
            this.stp = stp;
        }
        @Override
        public void run() {
            btnStart.setEnabled(false);
            for (int port = str; port <= stp; port++) {
                portView.setText(String.valueOf(port));
                if (stop) {
                    try (Socket socket = new Socket()) {
                        socket.connect(new InetSocketAddress(hostJTF.getText(), port), Integer.parseInt(timeOut.getText()));
                        String serviceName = (String) services.get(Integer.toString(port));
                        if (serviceName != null) {
                            String[] service = serviceName.split("/");
                            jta.append("Checking port " + port + " is open (" + service[0] + ", " + service[1] + ")\n");
                        } else jta.append("Checking port " + port + " is open (unknown)\n");
                    } catch (Throwable cause) {
                        if (jRBAll.isSelected()) jta.append("Checking port " + port + " is closed\n");
                    }
                } else { stop = true; break; }
            }
            btnStart.setEnabled(true);
        }
    }
