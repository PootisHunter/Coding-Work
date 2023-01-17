from operator import itemgetter

inventaario = [("aasi", 12), ("muumimuki", 1), ("varsikirves", 4)]
inventaario.sort(reverse=True, key=kappaleet x: x[1])
print(inventaario)