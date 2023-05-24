package ms.coleta.ic.coletalogs;


import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.TimeZone;
import org.apache.commons.vfs2.FileListener;
import org.apache.commons.vfs2.FileMonitor;
import org.apache.commons.vfs2.FileName;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.provider.AbstractFileSystem;

import ms.coleta.ic.coletalogs.AFileMonitor;
import ms.coleta.ic.coletalogs.AFileMonitor.FileMonitorAgent;

/**
 * A polling {@link FileMonitor} implementation.<br />
 * <br />
 * The DefaultFileMonitor is a Thread based polling file system monitor with a 1
 * second delay.<br />
 * <br />
 * <b>Design:</b>
 * <p>
 * There is a Map of monitors known as FileMonitorAgents. With the thread running,
 * each FileMonitorAgent object is asked to "check" on the file it is
 * responsible for.
 * To do this check, the cache is cleared.
 * </p>
 * <ul>
 * <li>If the file existed before the refresh and it no longer exists, a delete
 * event is fired.</li>
 * <li>If the file existed before the refresh and it still exists, check the
 * last modified timestamp to see if that has changed.</li>
 * <li>If it has, fire a change event.</li>
 * </ul>
 * <p>
 * With each file delete, the FileMonitorAgent of the parent is asked to
 * re-build its
 * list of children, so that they can be accurately checked when there are new
 * children.<br/>
 * New files are detected during each "check" as each file does a check for new
 * children.
 * If new children are found, create events are fired recursively if recursive
 * descent is
 * enabled.
 * </p>
 * <p>
 * For performance reasons, added a delay that increases as the number of files
 * monitored
 * increases. The default is a delay of 1 second for every 1000 files processed.
 * </p>
 * <br /><b>Example usage:</b><br /><pre>
 * FileSystemManager fsManager = VFS.getManager();
 * FileObject listendir = fsManager.resolveFile("/home/username/monitored/");
 * <p/>
 * DefaultFileMonitor fm = new DefaultFileMonitor(new CustomFileListener());
 * fm.setRecursive(true);
 * fm.addFile(listendir);
 * fm.start();
 * </pre>
 * <i>(where CustomFileListener is a class that implements the FileListener
 * interface.)</i>
 *
 * @author <a href="http://commons.apache.org/vfs/team-list.html">Commons VFS team</a>
 */

// public class FornoFileMonitor implements Runnable, FileMonitor
public class ConditionalMapFileMonitor extends AFileMonitor
{
	
	protected final Map<FileName, FornoFileMonitorAgent> monitorMap = new HashMap<FileName, FornoFileMonitorAgent>();
	
	protected static Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	
	private static TiposIsDeveMonitorar tipoIsDeveMonitorar = TiposIsDeveMonitorar.DEFAULT;
	
	public enum TiposIsDeveMonitorar {
		DEFAULT, DATAPROXIMA
	}
	
    public ConditionalMapFileMonitor(FileListener listener)
    {
    	super(listener);
    }
    
    public ConditionalMapFileMonitor(FileListener listener, TiposIsDeveMonitorar tipoIsDeveMonitorar)
    {
    	super(listener);
		this.tipoIsDeveMonitorar = tipoIsDeveMonitorar;
    }
    
    public static boolean isDeveMonitorar(FileObject file) {
    	// TODO: melhorar filtro para monitorar apenas os arquivos do
    	// ano e mes corrente
    	// 2018 data.txt
    	if (tipoIsDeveMonitorar == TiposIsDeveMonitorar.DEFAULT) {
    		return true;
    		
    	} else if (tipoIsDeveMonitorar == TiposIsDeveMonitorar.DATAPROXIMA) {
    		File arquivoModificado = new File(file.getName().getPath());
    		if (arquivoModificado.exists()) {
	    		Calendar calArquivoModificado = Calendar.getInstance();
	    		calArquivoModificado.setTime(new Date(arquivoModificado.lastModified()));
	    		calendar = Calendar.getInstance(TimeZone.getDefault());
	    	
	    		// 1 dia em millis = 86.400.000
	    		if ((calendar.getTimeInMillis() - calArquivoModificado.getTimeInMillis()) <= 86400000)
	    			return true;
    		}
    	}
		return false;
	}

    /**
     * Adds a file to be monitored.
     * @param file The FileObject to monitor.
     */
    @Override
    public void addFile(final FileObject file)
    {
        doAddFile(file, 0);
    }
    
    @Override
    public void addFile(final FileObject file, int currentLevel)
    {
    	if (!isDeveMonitorar(file))
    		return;
    	
        doAddFile(file, currentLevel);
        
      try
      {
    	  currentLevel = currentLevel + 1;
          // add all direct children too
          if (file.getType().hasChildren() && !(currentLevel > maxDepth))
          {
              // Traverse the children
              final FileObject[] children = file.getChildren();
              for (int i = 0; i < children.length; i++)
              {
                  doAddFile(children[i], currentLevel);
              }
          }
      }
      catch (FileSystemException fse)
      {
          LOG.error(fse.getLocalizedMessage(), fse);
      }
    }

	/**
     * Adds a file to be monitored.
     * @param file The FileObject to add.
     * @param current level of depth
     */
    private void doAddFile(final FileObject file, int currentLevel)
    {
        synchronized (this.monitorMap)
        {
        	boolean isFileELevelZero = false;
			try {
				// isFileELevelZero = (!file.isFolder() || (currentLevel == 0));
				isFileELevelZero = (!file.isFolder() || (currentLevel < maxDepth));
			} catch (FileSystemException e) {
				e.printStackTrace();
				LOG.error(e.getLocalizedMessage(), e);
			}
        	
            if ((this.monitorMap.get(file.getName()) == null) && (isFileELevelZero))
            {
            	this.monitorMap.put(file.getName(), new FornoFileMonitorAgent(this,
                // this.monitorMap.put(file.getName(), new FornoFileMonitorAgent(this,
                    file));

                try
                {
                    if (this.listener != null)
                    {
                        file.getFileSystem().addListener(file, this.listener);
                    }

                    currentLevel = currentLevel + 1;
                    if (file.getType().hasChildren() && this.recursive
                    		&& !(currentLevel > maxDepth))
                    {
                        // Traverse the children
                        final FileObject[] children = file.getChildren();
                        for (int i = 0; i < children.length; i++)
                        {
                            this.addFile(children[i], currentLevel); // Add depth first
                        }
                    }

                }
                catch (FileSystemException fse)
                {
                    LOG.error(fse.getLocalizedMessage(), fse);
                }

            }
        }
    }
    
    /**
     * Removes a file from being monitored.
     * @param file The FileObject to remove from monitoring.
     */
    public void removeFile(final FileObject file)
    {
        synchronized (this.monitorMap)
        {
            FileName fn = file.getName();
            if (this.monitorMap.get(fn) != null)
            {
                FileObject parent;
                try
                {
                    parent = file.getParent();
                }
                catch (FileSystemException fse)
                {
                    parent = null;
                }

                this.monitorMap.remove(fn);

                if (parent != null)
                { // Not the root
                    FornoFileMonitorAgent parentAgent =
                        this.monitorMap.get(parent.getName());
                    if (parentAgent != null)
                    {
                        parentAgent.resetChildrenList();
                    }
                }
            }
        }
    }
    
    /**
     * Asks the agent for each file being monitored to check its file for changes.
     */
    public void run()
    {
        mainloop:
        while (!monitorThread.isInterrupted() && this.shouldRun)
        {
            while (!this.deleteStack.empty())
            {
                this.removeFile(this.deleteStack.pop());
            }

            // For each entry in the map
            Object[] fileNames;
            synchronized (this.monitorMap)
            {
                fileNames = this.monitorMap.keySet().toArray();
            }
            for (int iterFileNames = 0; iterFileNames < fileNames.length;
                 iterFileNames++)
            {
                FileName fileName = (FileName) fileNames[iterFileNames];
                FornoFileMonitorAgent agent;
                synchronized (this.monitorMap)
                {
                    agent = this.monitorMap.get(fileName);
                }
                if (agent != null)
                {
                    agent.check();
                }

                if (getChecksPerRun() > 0)
                {
                    if ((iterFileNames % getChecksPerRun()) == 0)
                    {
                        try
                        {
                            Thread.sleep(getDelay());
                        }
                        catch (InterruptedException e)
                        {
                            // Woke up.
                        }
                    }
                }

                if (monitorThread.isInterrupted() || !this.shouldRun)
                {
                    continue mainloop;
                }
            }

            while (!this.addStack.empty())
            {
                this.addFile(this.addStack.pop());
            }

            try
            {
                Thread.sleep(getDelay());
            }
            catch (InterruptedException e)
            {
                continue;
            }
        }

        this.shouldRun = true;
    }
    
    //---------------------------------------
    /**
     * File monitor agent.
     */
    private static final class FornoFileMonitorAgent
    {
        private final FileObject file;
        // private final MapFileMonitor fm;
        private final AFileMonitor fm;
        

        private boolean exists;
        private long timestamp;
        private Map<FileName, Object> children;

        // private FileMonitorAgent(MapFileMonitor fm, FileObject file)
        public FornoFileMonitorAgent(AFileMonitor fm, FileObject file)
        
        {
            this.fm = fm;
            this.file = file;

            this.refresh();
            this.resetChildrenList();

            try
            {
                this.exists = this.file.exists();
            }
            catch (FileSystemException fse)
            {
                this.exists = false;
                this.timestamp = -1;
            }

            if (this.exists)
            {
                try
                {
                    this.timestamp = this.file.getContent().getLastModifiedTime();
                }
                catch (FileSystemException fse)
                {
                    this.timestamp = -1;
                }
            }
        }

        private void resetChildrenList()
        {
            try
            {
                if (this.file.getType().hasChildren())
                {
                    this.children = new HashMap<FileName, Object>();
                    FileObject[] childrenList = this.file.getChildren();
                    for (int i = 0; i < childrenList.length; i++)
                    {
                        this.children.put(childrenList[i].getName(), new
                            Object()); // null?
                    }
                }
            }
            catch (FileSystemException fse)
            {
                this.children = null;
            }
        }


        /**
         * Clear the cache and re-request the file object
         */
        private void refresh()
        {
            try
            {
                this.file.refresh();
            }
            catch (FileSystemException fse)
            {
                LOG.error(fse.getLocalizedMessage(), fse);
            }
        }


        /**
         * Recursively fires create events for all children if recursive descent is
         * enabled. Otherwise the create event is only fired for the initial
         * FileObject.
         * @param child The child to add.
         */
        private void fireAllCreate(FileObject child)
        {
            // Add listener so that it can be triggered
            if (this.fm.getFileListener() != null)
            {
                child.getFileSystem().addListener(child, this.fm.getFileListener());
            }

            ((AbstractFileSystem) child.getFileSystem()).fireFileCreated(child);

            // Remove it because a listener is added in the queueAddFile
            if (this.fm.getFileListener() != null)
            {
                child.getFileSystem().removeListener(child,
                    this.fm.getFileListener());
            }

            this.fm.queueAddFile(child); // Add

            try
            {

                if (this.fm.isRecursive())
                {
                    if (child.getType().hasChildren())
                    {
                        FileObject[] newChildren = child.getChildren();
                        for (int i = 0; i < newChildren.length; i++)
                        {
                            fireAllCreate(newChildren[i]);
                        }
                    }
                }

            }
            catch (FileSystemException fse)
            {
                LOG.error(fse.getLocalizedMessage(), fse);
            }
        }

        /**
         * Only checks for new children. If children are removed, they'll
         * eventually be checked.
         */
        private void checkForNewChildren()
        {
            try
            {
                if (this.file.getType().hasChildren())
                {
                    FileObject[] newChildren = this.file.getChildren();
                    if (this.children != null)
                    {
                        // See which new children are not listed in the current children map.
                        Map<FileName, Object> newChildrenMap = new HashMap<FileName, Object>();
                        Stack<FileObject> missingChildren = new Stack<FileObject>();

                        for (int i = 0; i < newChildren.length; i++)
                        {
                            newChildrenMap.put(newChildren[i].getName(), new
                                Object()); // null ?
                            // If the child's not there
                            if
                                (!this.children.containsKey(newChildren[i].getName()))
                            {
                            	if (isDeveMonitorar(newChildren[i]))
                            		missingChildren.push(newChildren[i]);
                            }
                        }

                        this.children = newChildrenMap;

                        // If there were missing children
                        if (!missingChildren.empty())
                        {

                            while (!missingChildren.empty())
                            {
                                FileObject child = missingChildren.pop();
                                this.fireAllCreate(child);
                            }
                        }

                    }
                    else
                    {
                        // First set of children - Break out the cigars
                        if (newChildren.length > 0)
                        {
                            this.children = new HashMap<FileName, Object>();
                        }
                        for (int i = 0; i < newChildren.length; i++)
                        {
                            this.children.put(newChildren[i].getName(), new
                                Object()); // null?
                            this.fireAllCreate(newChildren[i]);
                        }
                    }
                }
            }
            catch (FileSystemException fse)
            {
                LOG.error(fse.getLocalizedMessage(), fse);
            }
        }

        private void check()
        {
            this.refresh();

            try
            {
                // If the file existed and now doesn't
                if (this.exists && !this.file.exists())
                {
                    this.exists = this.file.exists();
                    this.timestamp = -1;

                    // Fire delete event

                    ((AbstractFileSystem)
                        this.file.getFileSystem()).fireFileDeleted(this.file);

                    // Remove listener in case file is re-created. Don't want to fire twice.
                    if (this.fm.getFileListener() != null)
                    {
                        this.file.getFileSystem().removeListener(this.file,
                            this.fm.getFileListener());
                    }

                    // Remove from map
                    this.fm.queueRemoveFile(this.file);
                }
                else if (this.exists && this.file.exists())
                {

                    // Check the timestamp to see if it has been modified
                    if (this.timestamp != this.file.getContent().getLastModifiedTime())
                    {
                        this.timestamp = this.file.getContent().getLastModifiedTime();
                        // Fire change event

                        // Don't fire if it's a folder because new file children
                        // and deleted files in a folder have their own event triggered.
                        if (!this.file.getType().hasChildren())
                        {
                            ((AbstractFileSystem)
                                this.file.getFileSystem()).fireFileChanged(this.file);
                        }
                    }

                }
                else if (!this.exists && this.file.exists())
                {
                    this.exists = this.file.exists();
                    this.timestamp = this.file.getContent().getLastModifiedTime();
                    // Don't fire if it's a folder because new file children
                    // and deleted files in a folder have their own event triggered.
                    if (!this.file.getType().hasChildren())
                    {
                        ((AbstractFileSystem)
                                this.file.getFileSystem()).fireFileCreated(this.file);
                    }
                }

                this.checkForNewChildren();

            }
            catch (FileSystemException fse)
            {
                LOG.error(fse.getLocalizedMessage(), fse);
            }
        }

    }
    
    
}
