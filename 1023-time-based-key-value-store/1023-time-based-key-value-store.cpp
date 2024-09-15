#include <map>
#include <string>
#include <unordered_map>

class TimeMap {
public:
    // Define a hash map where each key maps to another map (TreeMap equivalent in C++)
    std::unordered_map<std::string, std::map<int, std::string>> map;
    
    // Constructor
    TimeMap() {
        
    }
    
    // Set method to store key-value-timestamp
    void set(std::string key, std::string value, int timestamp) {
        // Insert the timestamp and value in the map for the given key
        map[key][timestamp] = value;
    }
    
    // Get method to retrieve the value associated with the largest timestamp <= the given timestamp
    std::string get(std::string key, int timestamp) {
        // Check if the key exists in the map
        if (map.find(key) == map.end()) {
            return "";
        }
        
        // Get the TreeMap (std::map) associated with the key
        auto& timeMap = map[key];
        
        // Use lower_bound to find the first timestamp greater than the given timestamp
        auto it = timeMap.upper_bound(timestamp);
        
        // If we don't have a valid timestamp less than or equal to the given timestamp
        if (it == timeMap.begin()) {
            return "";
        }
        
        // Move one step back to get the largest timestamp <= the given timestamp
        --it;
        
        // Return the corresponding value
        return it->second;
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */
