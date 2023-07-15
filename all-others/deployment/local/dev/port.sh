echo "clear all the ports: 8080 and 8005"

sudo kill -9 $(sudo lsof -ti:8080)
sudo kill -9 $(sudo lsof -ti:8005)
#sudo kill -9 $(sudo lsof -ti:8005)