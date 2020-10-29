package aplicacion;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author mivap
 */
public class Progress extends SwingWorker<Integer, String> {

    JProgressBar jpbar;

    public Progress(JProgressBar jpbar) {
        this.jpbar = jpbar;
    }   
    
    @Override
    protected Integer doInBackground() throws Exception {
        
        getJpbar().setIndeterminate(true);
        
        getJpbar().setIndeterminate(false);
        return 0;
    }

    public JProgressBar getJpbar() {
        return jpbar;
    }

    public void setJpbar(JProgressBar jpbar) {
        this.jpbar = jpbar;
    }
    
    
    
}
