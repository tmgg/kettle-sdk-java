# Usage



# api

reference pentaho-kettle\engine\src\main\resources\kettle-servlets.xml

## done

- status: Get the status of the server
- runTrans: Run a transformation directly from a repository
- runJob: Run a job directly from a repository


## todo

- transStatus: The the status of a transformation
- prepareExec: Prepare the execution of a transformation
- startExec: Start the execution of a transformation
- startTrans: Prepare and start the execution of a transformation
- pauseTrans: Pause or continue a transformation
- stopTrans: Stop a transformation
- cleanupTrans: Cleanup a transformation: close remote sockets, ...
- addTrans: Add a transformation for execution
- removeTrans: Remove a transformation
- allocateSocket: Service for the allocation of server sockets
- listSocket: Lists server socket allocation information
- sniffStep: Sniff test a transformation step
- executeTrans: Execute (prepare and start) a specific transformation and pass output to the servlet
- transImage: Generate a PNG image of a transformation


- startJob: Start a job
- stopJob: Stop a job
- jobStatus: Get the status of a job
- addJob: Add a job to the server
- removeJob: Remove a job from the server

- executeJob: Execute (prepare and start) a specific job
- jobImage: Generate a PNG image of a job

- registerJob: Add a job to the server
- registerTrans: Add a transformation to the server
- registerPackage: Upload a resources export file


- registerSlave: Register a slave server
- getSlaves: List all registered slave servers
- stopCarte: Stop Carte Server
- properties: Get properties from kettle.properties


- addExport: Upload a resources export file


- nextSequence: Get the next block of values for a sequence

# dev note

## response entity reference

pentaho-kettle/engine/src/main/java/org/pentaho/di/www/
