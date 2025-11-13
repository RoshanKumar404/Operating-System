 import java.io.*;
 public class IPCviaPipeline {
   public static void main(String[] args)throws IOException,InterruptedException {
    // creating the  first process
    ProcessBuilder Process1= new ProcessBuilder("cat","text");
   Process pb1=Process1.start();
    // creating the second process
    ProcessBuilder Process2= new ProcessBuilder("grep","JaiSriRam");
    Process pb2= Process2.start();

    // after creating the processes  now lets connect them 
    try(
        InputStream pb1output=pb1.getInputStream();
        OutputStream pb2Output= pb2.getOutputStream();

    ){
        pb1output.transferTo(pb2Output);
        
    }
    //closing the input to signal end of stream
    pb2.getOutputStream().close();
    //printing greps output  Grep:- this commands used to search the keywords in file using terminal or shell
    pb2.getInputStream().transferTo(System.out);
    

    // and lets wait for both processes to finish
    pb1.waitFor();
    pb2.waitFor();
    
   }
}


