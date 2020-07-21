package com.journaldev.spring.model;

import java.io.*;
import java.util.Iterator;

//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class StudentProfiles {
    static final Logger logger = LogManager.getLogger(StudentProfiles.class);
//    private Map<String, Stud> studProfiles;
    JSONObject studProfiles;
    JSONParser jsonParser = new JSONParser();
    SqlWork sql=new SqlWork();
    public StudentProfiles(){
//        studProfiles=new HashMap< String, Stud>();
//        studProfiles=new JSONObject();

        logger.debug("studProfiles made!");
    }
//    public void working(){
//        logger.debug("Working");
//    }
    public void setStudProfiles(Stud st) throws Exception {

//        st.printStud();

        sql.readDataBase(st);
//
        try{
            FileReader reader = new FileReader("C:\\Users\\ritik\\IdeaProjects\\spring-mvc-example\\src\\main\\Profiles.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray profilesList = (JSONArray) obj;
            System.out.println(profilesList);
            JSONObject studObject=new JSONObject();
            studObject.put("studName",st.getStudName());
            studObject.put("studId",st.getStudId());
            studObject.put("studClass",st.getStudClass());
            JSONObject profile=new JSONObject();
            String x=st.getStudId();
            profile.put(x,studObject);
//            JSONArray profilesList = new JSONArray();
            profilesList.add(profile);
            try{
                FileWriter file = new FileWriter("C:\\Users\\ritik\\IdeaProjects\\spring-mvc-example\\src\\main\\Profiles.json");
//                System.out.println(file);
//                System.out.println(x+" : "+profile.get(x));
                file.write(profilesList.toJSONString());

                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        if(this.studProfiles.containsKey(x)){
//
//             logger.warn("Already logged in");
//        }
//        else{
//            this.studProfiles.put(x,st);
            logger.debug("studProfiles set up correctly!");
//            try (FileWriter file = new FileWriter("Profiles.json")) {
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
    public Stud getStudProfiles(String x) throws Exception {
//        JSONParser jsonParser = new JSONParser();
            return sql.getDataBase(x);
//            try{
//            FileReader reader = new FileReader("C:\\Users\\ritik\\IdeaProjects\\spring-mvc-example\\src\\main\\Profiles.json");
////            logger.debug("FOUND FILE!!");
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray profilesList = (JSONArray) obj;
////            if(profilesList.contains(x)){
////                JSONObject studObject=new JSONObject();
////                studObject=(JSONObject)profilesList.get(x);
////                System.out.println(studObject);
////                Stud st=new Stud();
////                System.out.println(studObject.get("studName"));
////                System.out.println(studObject.get("studId"));
////                System.out.println(studObject.get("studClass"));
////            }
//            for(int i=0;i<profilesList.size();i++){
//                JSONObject studObject=new JSONObject();
//                studObject=(JSONObject)profilesList.get(i);
//                System.out.println(studObject);
//                if(studObject.containsKey(x)){
//                    Stud st=new Stud();
//                    JSONObject temp=new JSONObject();
//                    temp=(JSONObject)studObject.get(x);
//                    System.out.println(studObject.get(x));
//                    st.setStudName((String)temp.get("studName"));
//                    st.setStudId((String)temp.get("studId"));
//                    st.setStudClass((String)temp.get("studClass"));
//                    return st;
//                }
//            }
////            System.out.println(profilesList);
////            JSONObject Profile=new JSONObject();
////            String x=st.getStudId();
////            Profile.put(x,st);
////            Iterator it=profilesList.iterator();
////            it.forEachRemaining();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
////        if(this.studProfiles.containsKey(x)) {
////            logger.debug("studProfiles found correctly!");
////            Stud s1=this.studProfiles.get(x);
////            logger.info(x);
//////            s1.printStud();
////            return s1;
////        }
//        logger.warn(" id : "+x+" not present");
//        return null;
    }
}
