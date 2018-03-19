package guava.test_bai4;

import java.util.concurrent.TimeUnit;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
public class EmployeeGuavaCacheUtil {
    private static LoadingCache<Integer, Employee> empCache;
    static {
	empCache = CacheBuilder.newBuilder()
	       .maximumSize(100)
	       .expireAfterWrite(10, TimeUnit.MINUTES)
	       .build(
	           new CacheLoader<Integer, Employee>() {
        		@Override
			public Employee load(Integer id) throws Exception {
				return new Employee(id);
			}
	           }
	       );
    }
    public static LoadingCache<Integer, Employee> getLoadingCache() {
	return empCache;
    }
    public static Employee getEmployeeById(int id) {
	System.out.println("--Executing getEmployeeById--");
	//Perform any expensive task like fetching data from Database.
	//For the demo we are performing a simple task
	return new Employee(id);
   }
}
class Employee {
	private int id;
	private String name;
	public Employee(int id) {
		this.id = id;
		name = "so" + id; 
	}
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
} 