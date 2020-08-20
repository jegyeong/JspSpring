package kr.or.ddit.designpattern.pooling;

import java.io.IOException;
import java.io.Reader;

public class ReaderUtilNonPooling { 
    public ReaderUtilNonPooling() { 
    } 
 
    public String readToString(Reader in) throws IOException { 
        StringBuffer buf = new StringBuffer(); 
        try { 
            for(int c = in.read(); c != -1; c = in.read()) { 
                buf.append((char)c); 
            } 
            return buf.toString(); 
        } catch(IOException e) { 
            throw e; 
        } finally { 
            try { 
                in.close(); 
            } catch(Exception e) { 
                // ignored 
            } 
        } 
    } 
}