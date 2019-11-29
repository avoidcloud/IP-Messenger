/*
 * Copyright 2019 rafiul islam.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net;

import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author rafiul islam
 */
public class Client implements Connection{
    
    private String mHost;
    private int mPort;
    
    public Client(String pHost, int pPort){
        mHost = pHost;
        mPort = pPort;
    }
    
    @Override
    public void connect(ConnectionListener connectionListener){
        try{
            Socket socket = new Socket(mHost, mPort);
            connectionListener.onSuccess(socket);
        } catch(IOException ex){
            connectionListener.onFailed(ex);
        }
    }
}