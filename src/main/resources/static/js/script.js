window.addEventListener('load', function() {

    function processData() {
        let payload = $('.payload').val();

        $.ajax({
            type: 'POST',
            url: '/result',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(payload),
            success: function(data) {
                $('.result').val(result(data));
            }
        });
    }

    let form = document.getElementById('myForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault();
        processData();
    });

    function result(data) {
        let result = '';
        if (Object.keys(data).length == 0) {
            result = 'No words to display';
        } else {
            let unique = 0;
            for (let i in data) {
                if (data[i].entry == 1) {
                    unique++;
                } else {
                    result += data[i].word + ' - ' + data[i].entry + '\n';
                }
            }
            result += 'Unique' + ' : ' + unique;
        }
        return result;
    }
});