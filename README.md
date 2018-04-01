# AndroidAsyncTask

### Notes

- `AsyncTask` still running even the activity that started it is destroyed
- `AsyncTask` can run in background
-  We can not execute `AsyncTask` during it is running or after it finish. Need to create new instance

### AsyncTask vs Intent Service
https://stackoverflow.com/questions/15167152/should-i-use-asynctask-or-intentservice-for-my-application/49585912#49585912
