from django.shortcuts import HttpResponse, render
import random
import sys
import requests

def extract_names(filename):
  names = []
  f = open(filename, 'rU')
  text = f.read()
  year_match = re.search(r'Popularity\sin\s(\d\d\d\d)', text)
  if not year_match:
    sys.stderr.write('Couldn\'t find the year!\n')
    sys.exit(1)
  year = year_match.group(1)
  names.append(year)
  tuples = re.findall(r'<td>(\d+)</td><td>(\w+)</td>\<td>(\w+)</td>', text)
  names_to_rank =  {}
  for rank_tuple in tuples:
    (rank, boyname, girlname) = rank_tuple  # unpack the tuple into 3 vars
    if boyname not in names_to_rank:
      names_to_rank[boyname] = rank
    if girlname not in names_to_rank:
      names_to_rank[girlname] = rank
  sorted_names = sorted(names_to_rank.keys())
  for name in sorted_names:
    names.append(name + " " + names_to_rank[name])
  return names