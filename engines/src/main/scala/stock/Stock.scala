package io.prediction.engines.stock

import io.prediction.controller.LAlgorithm
import io.prediction.controller.Params
import scala.reflect._

object Settings {
  val appid = 1008
  
  val sp500List = Vector(
    "A", "AA", "AAPL", "ABBV", "ABC", "ABT", "ACE", "ACN", "ACT", "ADBE", "ADI",
    "ADM", "ADP", "ADS", "ADSK", "ADT", "AEE", "AEP", "AES", "AET", "AFL",
    "AGN", "AIG", "AIV", "AIZ", "AKAM", "ALL", "ALLE", "ALTR", "ALXN", "AMAT",
    "AME", "AMGN", "AMP", "AMT", "AMZN", "AN", "AON", "APA", "APC", "APD",
    "APH", "ARG", "ATI", "AVB", "AVP", "AVY", "AXP", "AZO", "BA", "BAC", "BAX",
    "BBBY", "BBT", "BBY", "BCR", "BDX", "BEAM", "BEN", "BF-B", "BHI", "BIIB",
    "BK", "BLK", "BLL", "BMS", "BMY", "BRCM", "BRK-B", "BSX", "BTU", "BWA",
    "BXP", "C", "CA", "CAG", "CAH", "CAM", "CAT", "CB", "CBG", "CBS", "CCE",
    "CCI", "CCL", "CELG", "CERN", "CF", "CFN", "CHK", "CHRW", "CI", "CINF",
    "CL", "CLX", "CMA", "CMCSA", "CME", "CMG", "CMI", "CMS", "CNP", "CNX",
    "COF", "COG", "COH", "COL", "COP", "COST", "COV", "CPB", "CRM", "CSC",
    "CSCO", "CSX", "CTAS", "CTL", "CTSH", "CTXS", "CVC", "CVS", "CVX", "D",
    "DAL", "DD", "DE", "DFS", "DG", "DGX", "DHI", "DHR", "DIS", "DISCA", "DLPH",
    "DLTR", "DNB", "DNR", "DO", "DOV", "DOW", "DPS", "DRI", "DTE", "DTV", "DUK",
    "DVA", "DVN", "EA", "EBAY", "ECL", "ED", "EFX", "EIX", "EL", "EMC", "EMN",
    "EMR", "EOG", "EQR", "EQT", "ESRX", "ESS", "ESV", "ETFC", "ETN", "ETR",
    "EW", "EXC", "EXPD", "EXPE", "F", "FAST", "FB", "FCX", "FDO", "FDX", "FE",
    "FFIV", "FIS", "FISV", "FITB", "FLIR", "FLR", "FLS", "FMC", "FOSL", "FOXA",
    "FRX", "FSLR", "FTI", "FTR", "GAS", "GCI", "GD", "GE", "GGP", "GHC", "GILD",
    "GIS", "GLW", "GM", "GMCR", "GME", "GNW", "GOOG", "GOOGL", "GPC", "GPS",
    "GRMN", "GS", "GT", "GWW", "HAL", "HAR", "HAS", "HBAN", "HCBK", "HCN",
    "HCP", "HD", "HES", "HIG", "HOG", "HON", "HOT", "HP", "HPQ", "HRB", "HRL",
    "HRS", "HSP", "HST", "HSY", "HUM", "IBM", "ICE", "IFF", "IGT", "INTC",
    "INTU", "IP", "IPG", "IR", "IRM", "ISRG", "ITW", "IVZ", "JBL", "JCI", "JEC",
    "JNJ", "JNPR", "JOY", "JPM", "JWN", "K", "KEY", "KIM", "KLAC", "KMB", "KMI",
    "KMX", "KO", "KORS", "KR", "KRFT", "KSS", "KSU", "L", "LB", "LEG", "LEN",
    "LH", "LLL", "LLTC", "LLY", "LM", "LMT", "LNC", "LO", "LOW", "LRCX", "LSI",
    "LUK", "LUV", "LYB", "M", "MA", "MAC", "MAR", "MAS", "MAT", "MCD", "MCHP",
    "MCK", "MCO", "MDLZ", "MDT", "MET", "MHFI", "MHK", "MJN", "MKC", "MMC",
    "MMM", "MNST", "MO", "MON", "MOS", "MPC", "MRK", "MRO", "MS", "MSFT", "MSI",
    "MTB", "MU", "MUR", "MWV", "MYL", "NBL", "NBR", "NDAQ", "NE", "NEE", "NEM",
    "NFLX", "NFX", "NI", "NKE", "NLSN", "NOC", "NOV", "NRG", "NSC", "NTAP",
    "NTRS", "NU", "NUE", "NVDA", "NWL", "NWSA", "OI", "OKE", "OMC", "ORCL",
    "ORLY", "OXY", "PAYX", "PBCT", "PBI", "PCAR", "PCG", "PCL", "PCLN", "PCP",
    "PDCO", "PEG", "PEP", "PETM", "PFE", "PFG", "PG", "PGR", "PH", "PHM", "PKI",
    "PLD", "PLL", "PM", "PNC", "PNR", "PNW", "POM", "PPG", "PPL", "PRGO", "PRU",
    "PSA", "PSX", "PVH", "PWR", "PX", "PXD", "QCOM", "QEP", "R", "RAI", "RDC",
    "REGN", "RF", "RHI", "RHT", "RIG", "RL", "ROK", "ROP", "ROST", "RRC", "RSG",
    "RTN", "SBUX", "SCG", "SCHW", "SE", "SEE", "SHW", "SIAL", "SJM", "SLB",
    "SLM", "SNA", "SNDK", "SNI", "SO", "SPG", "SPLS", "SRCL", "SRE", "STI",
    "STJ", "STT", "STX", "STZ", "SWK", "SWN", "SWY", "SYK", "SYMC", "SYY", "T",
    "TAP", "TDC", "TE", "TEG", "TEL", "TGT", "THC", "TIF", "TJX", "TMK", "TMO",
    "TRIP", "TROW", "TRV", "TSCO", "TSN", "TSO", "TSS", "TWC", "TWX", "TXN",
    "TXT", "TYC", "UNH", "UNM", "UNP", "UPS", "URBN", "USB", "UTX", "V", "VAR",
    "VFC", "VIAB", "VLO", "VMC", "VNO", "VRSN", "VRTX", "VTR", "VZ", "WAG",
    "WAT", "WDC", "WEC", "WFC", "WFM", "WHR", "WIN", "WLP", "WM", "WMB", "WMT",
    "WU", "WY", "WYN", "WYNN", "X", "XEL", "XL", "XLNX", "XOM", "XRAY", "XRX",
    "XYL", "YHOO", "YUM", "ZION", "ZMH", "ZTS")
  val marketList = Vector("QQQ", "SPY")
}

abstract class StockAlgorithm[P <: Params : ClassTag, M : ClassTag] 
  extends LAlgorithm[P, TrainingData, M, Query, Target] {
  def train(trainingData: TrainingData): M

  def predict(model: M, query: Query): Target
}
