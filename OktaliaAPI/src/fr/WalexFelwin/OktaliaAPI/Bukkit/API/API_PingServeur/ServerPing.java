package fr.WalexFelwin.OktaliaAPI.Bukkit.API.API_PingServeur;
 
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

import org.bukkit.Bukkit;

import com.google.gson.Gson;


public class ServerPing {  
	
	private boolean fetching;
    private InetSocketAddress host;
    private int timeout = 7000;
    
    public void setAddress(InetSocketAddress host)  {
        this.host = host;
        this.fetching = false;
    }
 
    public InetSocketAddress getAddress() {
        return this.host;
    }
 
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
 
    public int getTimeout() {
        return this.timeout;
    }
    
    public boolean isFetching() {
    	return fetching;
    }
    
    public void setFetching(boolean pinging) {
    	this.fetching = pinging;
    }
 
    public int readVarInt(DataInputStream in) throws IOException {
        int i = 0;
        int j = 0;
        while (true) {
            int k = in.readByte();
            i |= (k & 0x7F) << j++ * 7;
            if (j > 5) throw new RuntimeException("VarInt too big");
            if ((k & 0x80) != 128) break;
        }
        return i;
    }
 
    public void writeVarInt(DataOutputStream out, int paramInt) throws IOException {
        while (true) {
            if ((paramInt & 0xFFFFFF80) == 0) {
              out.writeByte(paramInt);
              return;
            }
            out.writeByte(paramInt & 0x7F | 0x80);
            paramInt >>>= 7;
        }
    }
    
	private String getBukkitVersion(){
		String version = Bukkit.getVersion();
		version = version.replace("(", "");
		version = version.replace(")", "");
		version = version.split(" ")[2];
		return version;
	}
    
    @SuppressWarnings({ "resource", "unused" })
	public StatusResponse fetchData() throws IOException {
    	if(getBukkitVersion().contains("1.8")){
    		com.google.gson.Gson gson = new com.google.gson.Gson();
            Socket socket = new Socket();
            OutputStream outputStream;
            DataOutputStream dataOutputStream;
            InputStream inputStream;
            InputStreamReader inputStreamReader;

            socket.setSoTimeout(this.timeout);
            socket.connect(host, timeout);

            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);

            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);

            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream handshake = new DataOutputStream(b);
            handshake.writeByte(0x00);
            writeVarInt(handshake, 4);
            writeVarInt(handshake, this.host.getHostString().length());
            handshake.writeBytes(this.host.getHostString());
            handshake.writeShort(host.getPort());
            writeVarInt(handshake, 1);

            writeVarInt(dataOutputStream, b.size());
            dataOutputStream.write(b.toByteArray());

            dataOutputStream.writeByte(0x01);
            dataOutputStream.writeByte(0x00);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int size = readVarInt(dataInputStream);
            int id = readVarInt(dataInputStream);
            
            if (id == -1) {
                throw new IOException("Premature end of stream.");
            }
            
            if (id != 0x00){
                throw new IOException("Invalid packetID");
            }
            int length = readVarInt(dataInputStream);
            
            if (length == -1) {
                throw new IOException("Premature end of stream.");
            }

            if (length == 0) {
                throw new IOException("Invalid string length.");
            }
            
            byte[] in = new byte[length];
            dataInputStream.readFully(in);
            String json = new String(in);
            
            
            long now = System.currentTimeMillis();
            dataOutputStream.writeByte(0x09);
            dataOutputStream.writeByte(0x01);
            dataOutputStream.writeLong(now);

            readVarInt(dataInputStream);
            id = readVarInt(dataInputStream);
            if (id == -1) {
                throw new IOException("Premature end of stream.");
            }
            
            if (id != 0x01) {
                throw new IOException("Invalid packetID");
            }
            long pingtime = dataInputStream.readLong();

            StatusResponse response = gson.fromJson(json, StatusResponse.class);
            response.setTime((int) (now - pingtime));
            
            dataOutputStream.close();
            outputStream.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
            
            return response;
    	}
    	
    	Gson gson = new Gson();
    	
        Socket socket = new Socket();
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        InputStreamReader inputStreamReader;

        socket.setSoTimeout(this.timeout);
        socket.connect(host, timeout);

        outputStream = socket.getOutputStream();
        dataOutputStream = new DataOutputStream(outputStream);

        inputStream = socket.getInputStream();
        inputStreamReader = new InputStreamReader(inputStream);

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream handshake = new DataOutputStream(b);
        handshake.writeByte(0x00);
        writeVarInt(handshake, 4);
        writeVarInt(handshake, this.host.getHostString().length());
        handshake.writeBytes(this.host.getHostString());
        handshake.writeShort(host.getPort());
        writeVarInt(handshake, 1);

        writeVarInt(dataOutputStream, b.size());
        dataOutputStream.write(b.toByteArray());

        dataOutputStream.writeByte(0x01);
        dataOutputStream.writeByte(0x00);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int size = readVarInt(dataInputStream);
        int id = readVarInt(dataInputStream);
        
        if (id == -1) {
            throw new IOException("Premature end of stream.");
        }
        
        if (id != 0x00) {
            throw new IOException("Invalid packetID");
        }
        int length = readVarInt(dataInputStream);
        
        if (length == -1) {
            throw new IOException("Premature end of stream.");
        }

        if (length == 0) {
            throw new IOException("Invalid string length.");
        }
        
        byte[] in = new byte[length];
        dataInputStream.readFully(in);
        String json = new String(in);
        
        
        long now = System.currentTimeMillis();
        dataOutputStream.writeByte(0x09);
        dataOutputStream.writeByte(0x01);
        dataOutputStream.writeLong(now);

        readVarInt(dataInputStream);
        id = readVarInt(dataInputStream);
        if (id == -1) {
            throw new IOException("Premature end of stream.");
        }
        
        if (id != 0x01) {
            throw new IOException("Invalid packetID");
        }
        long pingtime = dataInputStream.readLong();

        StatusResponse response = gson.fromJson(json, StatusResponse.class);
        response.setTime((int) (now - pingtime));
        
        dataOutputStream.close();
        outputStream.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
        
        return response;
    }
    
    public class StatusResponse
    {
      private String description;
      private Players players;
      private Version version;
      private String favicon;
      private int time;
      
      public String getDescription()
      {
        return this.description;
      }
      
      public Players getPlayers()
      {
        return this.players;
      }
      
      public Version getVersion()
      {
        return this.version;
      }
      
      public String getFavicon()
      {
        return this.favicon;
      }
      
      public int getTime()
      {
        return this.time;
      }
      
      public void setTime(int time)
      {
        this.time = time;
      }
      
      public class Players
      {
        private int max;
        private int online;
        private List<StatusResponse.Player> sample;
        
        public Players() {}
        
        public int getMax()
        {
          return this.max;
        }
        
        public int getOnline()
        {
          return this.online;
        }
        
        public List<StatusResponse.Player> getSample()
        {
          return this.sample;
        }
      }
      
      public class Player
      {
        private String name;
        private String id;
        
        public Player() {}
        
        public String getName()
        {
          return this.name;
        }
        
        public String getId()
        {
          return this.id;
        }
      }
      
      public class Version
      {
        private String name;
        private String protocol;
        
        public Version() {}
        
        public String getName()
        {
          return this.name;
        }
        
        public String getProtocol()
        {
          return this.protocol;
        }
      }}
    }