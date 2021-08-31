from django.shortcuts import render
from django.http import HttpResponse
from view_comp_reply.models import ComplaintAndGiveReply




# Create your views here.

def v_reply(request):
    objlist=ComplaintAndGiveReply.objects.filter(reply='pending')
    context={
        'objval':objlist,
    }

    return render(request, 'view_comp_reply/view_com_reply.html', context)

def post_reply(request):
    if request.method=="POST":
        tp=str(request.session['ex'])

        #return getvalues(request)
        obj=ComplaintAndGiveReply.objects.get(id=tp)

        obj.reply = request.POST.get("reply")
        obj.save()
        return v_reply(request)

    else:
        return render(request,'view_comp_reply/post_reply.html')

def reply(request,cid):
    request.session['ex']=cid

    return post_reply(request)
