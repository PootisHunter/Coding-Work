import Miinaharava as mh

Kenttatiedot = {
    "miinojen_maara" : 25,
    "kentan_leveys" : 30,
    "kentan_korkeus" : 16,
    "miina_kentta" : [],
    "miina_lista" : []
}

mh.luo_kentta(Kenttatiedot["kentan_korkeus"], mh.Kenttatiedot["kentan_leveys"])
kenttalista = mh.listaa_kentta(Kenttatiedot["miina_kentta"])
mh.miinoita(Kenttatiedot["miina_kentta"], kenttalista, Kenttatiedot["miinojen_maara"])
mh.numerointi(Kenttatiedot["miina_kentta"], Kenttatiedot["miina_lista"])