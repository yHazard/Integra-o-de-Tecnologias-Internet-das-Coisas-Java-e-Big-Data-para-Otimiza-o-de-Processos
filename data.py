from mrjob.job import MRJob

class MRTemperatureAverage(MRJob):
    
    def mapper(self, _, line):
        try:
            temperature = float(line.split(',')[0])
            yield "average", temperature
        except:
            pass
    
    def reducer(self, key, values):
        total = 0
        count = 0
        for value in values:
            total += value
            count += 1
        yield key, total / count if count else 0

if __name__ == '__main__':
    MRTemperatureAverage.run()
