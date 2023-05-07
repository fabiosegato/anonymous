class SortObject {

    static dynamicSort(property, tipo) {
        var sortOrder = 1;

        if (property[0] === "-") {
            sortOrder = -1;
            property = property.substr(1);
        }

        return function (a, b) {
            if (tipo != "number") {
                if (sortOrder == -1) {
                    return b[property].localeCompare(a[property]);
                } else {
                    return a[property].localeCompare(b[property]);
                }
            }
            else {
                if (parseInt(a[property]) < parseInt(b[property])) {
                    return -1;
                } else if (parseInt(a[property]) > parseInt(b[property])) {
                    return 1;
                } else {
                    return 0;
                }
            }







        }
    }

}