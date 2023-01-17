

def muotoile_heksaluvuksi(luku, bitti_määrä):
    muutettu_luku = hex(luku)
    lyhennetty_luku = muutettu_luku.lstrip("0x")
    pidennetty_luku = lyhennetty_luku.zfill(bitti_määrä // 4)
    return pidennetty_luku
