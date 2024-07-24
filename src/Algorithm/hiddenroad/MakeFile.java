package Algorithm.hiddenroad;

import java.util.*;

public class MakeFile {

    Map<String, String> m_taskOutput= new HashMap<>();
    Map<String, Set<String>> m_path = new HashMap<>();

    Set<String> m_validTarget = new HashSet<>();

    public static void main(String[] args) {
        String input ="-A:\n"+
                "output_A\n"+
                "-B:D\n"+
                "output_B\n"+
                "-C:A B\n"+
                "output_C\n"+
                "-D:A\n"+
                "output_D\n";

        MakeFile mf = new MakeFile();
        mf.parse(input);

        System.out.println(mf.m_taskOutput);
        for(Map.Entry e: mf.m_path.entrySet()){
            System.out.println(" key "+e.getKey()+" set "+e.getValue());
        }


        mf.make("C", new HashSet<>());


    }

    class Task{
        String m_name;
        List<String> m_childs = new ArrayList<>();
        String m_output ;

        Task(String name, String output){
            m_name = name;
            m_output =output;
        }

    }

    public void make(String target, HashSet<String> visited){
        if(visited.contains(target))
            return;
        if(!m_taskOutput.containsKey(target)) {
            System.err.println(" not found "+target);
            return;
        }
        System.out.println(" make "+target);
        if(hasCycle(target, new HashSet<>())) {
            System.err.println(" cycle error "+target);
            return;
        }

        for(String child: m_path.getOrDefault(target, new HashSet<>())){
            make(child, visited);
        }
        System.out.println("-->"+m_taskOutput.get(target));
        visited.add(target);
    }

    private boolean hasCycle(String target, HashSet<String> visiting ) {

        if(m_validTarget.contains(target))
            return false;
        System.out.println(" has cycle "+target);
        visiting.add(target);
        Set<String> childs = m_path.getOrDefault(target, new HashSet<>());
        for(String c: childs){
            if(visiting.contains(c))
                return true;
            if(hasCycle(c, visiting))
                return true;
        }
        visiting.remove(target);
        m_validTarget.add(target);
        return false;


    }

    public  void parse(String args){

        String taskName =null;
        String output=null;

        for(String line: args.split("\n")){
            if(line.indexOf("-")==0){
                output = "";
                 taskName = line.substring(1, line.indexOf(":"));
                if(line.length()-1>line.indexOf(":")){
                    //has deps
                    String[] deps = line.substring(line.indexOf(":")+1, line.length()).split(" ");
                    Set<String> set = m_path.getOrDefault(taskName, new HashSet<String>());
                    for(String dep: deps){
                        set.add(dep);
                    }
                    m_path.put(taskName,set);
                }
            } else {
                output = m_taskOutput.getOrDefault(taskName,"");
                output += line;
                m_taskOutput.put(taskName, output);
            }
        }


    }
}
