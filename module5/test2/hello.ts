function show(name?: string) : string {

    let message = 'Hello';

    if(name){

        message += ' ' + name;

    }

    return message;

}
console.log(show('CodeGym'));
console.log(show());