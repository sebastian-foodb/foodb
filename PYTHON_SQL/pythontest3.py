
# Testing for python database server
#
# submits post request to pythonanywhere
#

# importing the requests library
import requests

# api-endpoint
URL = "http://Npgreader2.pythonanywhere.com"

# set up params
queryType = "Exact"
foodName = "bagelswheat"

# defining a params dict for the parameters to be sent to the API
PARAMS = {'queryType':queryType,'parameters':foodName}
header = {'Content-Type':'application/json'};


# sending post request and saving the response as response object
r = requests.post(url = URL, json = PARAMS, headers = header)

# extracting data in json format
print(r);
print(r.text);
data = r.json()
print(data);
print(data['sanity']);
