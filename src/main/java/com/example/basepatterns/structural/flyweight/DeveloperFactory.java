package com.example.basepatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * это и есть приспособленец, легковес, flyweight,
 * мы будем выдавать из этой фабрики разработчиков, если не будет хватать - создавать новых
 */
public class DeveloperFactory {
    private static final Map<String, Developer> developers = new HashMap<>();

    public Developer getDeveloperBySpeciality(String speciality)  {
        Developer developer = developers.get(speciality);
        if (developer == null){
            switch (speciality){
                case "java" :
                    System.out.println("Hiring java developer...");
                    developer = new JavaDeveloper();
                    break;
                case "c++":
                    System.out.println("Hiring c++ developer...");
                    developer = new CppDeveloper();
            }
            developers.put(speciality, developer);
        }
        return developer;
    }
}
