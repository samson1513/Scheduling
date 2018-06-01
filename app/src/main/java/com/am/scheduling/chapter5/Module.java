package com.am.scheduling.chapter5;

import java.io.Serializable;

/**
 * Simple course module abstraction, which defines the Professors teaching the module.
 */
public class Module implements Serializable {
    private final int moduleId;
    private final String module;
    private final int professorIds[];

    public Module(int moduleId, String module, int professorIds[]){
        this.moduleId = moduleId;
        this.module = module;
        this.professorIds = professorIds;
    }
    
    /**
     * Get moduleId
     * 
     * @return moduleId
     */
    public int getModuleId(){
        return this.moduleId;
    }

    
    /**
     * Get module name
     * 
     * @return moduleName
     */
    public String getModuleName(){
        return this.module;
    }
    
    /**
     * Get random professor Id
     * 
     * @return professorId
     */
    public int getRandomProfessorId(){
        int professorId = professorIds[(int) (professorIds.length * Math.random())];
        return professorId;
    }
}
