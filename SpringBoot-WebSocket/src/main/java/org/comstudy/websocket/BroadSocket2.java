package org.comstudy.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

@Service
@ServerEndpoint(value = "/broadSocket2/{userID}")
public class BroadSocket2 {
   // 메세지를 저장하는 컬렉션
   // 브로드케스트를 위해 해쉬셋은 동기화 지원 안됨. 동기화 되도록 선언해야 한다.
   //static Set<Session> clientSessionSet = Collections.synchronizedSet(new HashSet<Session>() );
   
   // 귓속말 기능은 socket id를 알아야 하기 때문에 Map구조로 session을 저장한다.
   static Map<String, Session> sessionMap = 
         Collections.synchronizedMap(new HashMap<String, Session>() );
   
   
   @OnOpen
   public void onOpen(Session session, @PathParam("userID") String userID) throws IOException {
      System.out.println(">>> 소켓 서버"+ userID +"(이)가 오픈 되었습니다.");
      //clientSessionSet.add(session);
      // PathParam 외에도 ?쿼리스트링이나 getRequestParameterMap등을 활용 할 수도 있다.
      System.out.println(">>> userID : " + userID);
      sessionMap.put(userID, session);
      
      for(String key : sessionMap.keySet()) {
         var clientSession = sessionMap.get(key);
         clientSession.getBasicRemote().sendText(userID + "님이 입장했습니다.");
      }
   }
   
   @OnClose
   public void onClose(Session session) {
      System.out.println(">>> 소켓 서버"+ session.getId() +"(이)가 닫혔습니다.");
      //clientSessionSet.remove(session);
   }
   
   @OnMessage
   public void onMessage(String message, Session session, @PathParam("userID") String userID) throws IOException {
      System.out.println(">>> 받은 메세지 : " + message);
      
      StringTokenizer tokens = new StringTokenizer(message, "||");
      String recipient = tokens.nextToken().trim();
      String msg = tokens.nextToken();
      
      System.out.println("받는이>>> " + recipient);
      System.out.println("메세지>>> " + msg);
      
      if("All".equals(recipient)) {
         for(String key : sessionMap.keySet()) {
            if(!userID.equals(key)) {
               var clientSession = sessionMap.get(key);
               clientSession.getBasicRemote().sendText(userID+" : " + msg);
            }
         }
      } else {
         if(sessionMap.get(recipient) != null) {         
            (sessionMap.get(recipient)).getBasicRemote().sendText(userID+" : " + msg);
         }
      }
      
      
//      synchronized (clientSessionSet) {
//         System.out.println("접속자 수 : " + clientSessionSet.size());
//         for(Session clientSession : clientSessionSet) {
//            if(!session.equals(clientSession)) {
//               clientSession.getBasicRemote().sendText(session.getId() + ": " + message);
//            }
//         }
//      }
   }
   
   @OnError
   public void onError(Throwable th) {
      th.printStackTrace();
   }
}