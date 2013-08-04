/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author User
 */
class DataBean {
    String level;
    String name;
    String id;
    
    public String getLevel(){
        return level;
    }
    
    public void setLevel(String level){
        this.level=level;
    }
    
      public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
      public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id=id;
    }
    @Override
    public String toString() {
	   StringBuilder builder = new StringBuilder();
		return builder.append("level : ").append(level).append(" name : ").append(name).append(" id : ").append(id).toString();
	}
    
}
